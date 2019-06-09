package com.yqwl.common.verifyCode.utils;

import static com.yqwl.common.verifyCode.utils.Randoms.num;

import java.awt.AlphaComposite;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.OutputStream;

public class SpecCaptcha extends Captcha {
	public SpecCaptcha() {
	}

	public SpecCaptcha(int width, int height) {
		this.width = width;
		this.height = height;
	}

	public SpecCaptcha(int width, int height, int len) {
		this(width, height);
		this.len = len;
	}

	public SpecCaptcha(int width, int height, int len, Font font) {
		this(width, height, len);
		this.font = font;
	}

	/**
	 * 生成验证码
	 * 
	 * @throws java.io.IOException
	 *             IO异常
	 */
	@Override
	public BufferedImage out(OutputStream out) {
		return graphicsImage(alphas(), out);
	}

	/**
	 * 画随机码图
	 * 
	 * @param strs
	 *            文本
	 * @param out
	 *            输出流
	 */
	private BufferedImage graphicsImage(char[] strs, OutputStream out) {
		BufferedImage bi = null;
		bi = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
		Graphics2D g = (Graphics2D) bi.getGraphics();
		AlphaComposite ac3;
		Color color;
		int len = strs.length;
		g.setColor(Color.WHITE);
		g.fillRect(0, 0, width, height);
		// 随机画干扰的圆圈
		for (int i = 0; i < 15; i++) {
			color = color(150, 250);
			g.setColor(color);
			g.drawOval(num(width), num(height), 5 + num(10), 5 + num(10));// 画圆圈
			color = null;
		}
		g.setFont(font);
		int h = height - ((height - font.getSize()) >> 1), w = width / len, size = w - font.getSize() + 1;
		/* 画字符串 */
		for (int i = 0; i < len; i++) {
			ac3 = AlphaComposite.getInstance(AlphaComposite.SRC_OVER, 0.7f);// 指定透明度
			g.setComposite(ac3);
			color = new Color(20 + num(110), 20 + num(110), 20 + num(110));// 对每个字符都用随机颜色
			g.setColor(color);
			g.drawString(strs[i] + "", (width - (len - i) * w) + size, h - 4);
			color = null;
			ac3 = null;
		}
		return bi;
	}

}