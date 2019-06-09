package com.yqwl.service.impl;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.commons.lang3.time.DateUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.yqwl.common.utils.DateUtil;
import com.yqwl.dao.AmountMapper;
import com.yqwl.dao.MessageMapper;
import com.yqwl.pojo.Amount;
import com.yqwl.service.AmountService;
import com.yqwl.service.MessageService;
import com.yqwl.vo.StatisticsVo;
import com.yqwl.vo.TotalVo;

@Service("amountService")
@Transactional(rollbackFor = { Exception.class })
public class AmountServiceImpl implements AmountService {
	@Resource
	private AmountMapper amountMapper;
	@Resource
	private MessageMapper messageMapper;

	@Override
	public int addVisit(String ip) throws Exception {
		Amount amount = new Amount();
		amount.setIp(ip);
		amount.setTime(new Date());
		return amountMapper.insertSelective(amount);
	}

	@Override
	public TotalVo total() throws Exception {
		TotalVo totalVo = new TotalVo();
		int visit_total = amountMapper.total();
		totalVo.setVisit_total(visit_total);
		int message_total = messageMapper.total();
		totalVo.setMessage_total(message_total);
		BigDecimal bd = new BigDecimal((double) message_total / visit_total * 100);
		totalVo.setPercent(bd.setScale(2, BigDecimal.ROUND_HALF_UP).toString());
		return totalVo;
	}

	@Override
	public Map<String, Object> listAllByDate(int dateType) throws Exception {
		Map<String, Object> map = new HashMap<>();
		List<Amount> list = new LinkedList<>();
		String format;
		Date now = new Date();
		switch (dateType) {
		case 1:
			format = "HH:mm:ss";
			String Day[] = { "00:00", "03:00", "06:00", "09:00", "12:00", "15:00", "18:00", "21:00" };
			int DayData[] = { 0, 0, 0, 0, 0, 0, 0, 0 };
			list = amountMapper.listByNow();
			for (Amount amount : list) {
				if (DateUtil.isEffectiveDate(DateUtil.getTimeShort(amount.getTime()),
						new SimpleDateFormat(format).parse("00:00:00"),
						new SimpleDateFormat(format).parse("02:59:59"))) {
					DayData[0] = DayData[0] + 1;
				} else if (DateUtil.isEffectiveDate(DateUtil.getTimeShort(amount.getTime()),
						new SimpleDateFormat(format).parse("03:00:00"),
						new SimpleDateFormat(format).parse("05:59:59"))) {
					DayData[1] = DayData[1] + 1;
				} else if (DateUtil.isEffectiveDate(DateUtil.getTimeShort(amount.getTime()),
						new SimpleDateFormat(format).parse("06:00:00"),
						new SimpleDateFormat(format).parse("08:59:59"))) {
					DayData[2] = DayData[2] + 1;
				} else if (DateUtil.isEffectiveDate(DateUtil.getTimeShort(amount.getTime()),
						new SimpleDateFormat(format).parse("09:00:00"),
						new SimpleDateFormat(format).parse("11:59:59"))) {
					DayData[3] = DayData[3] + 1;
				} else if (DateUtil.isEffectiveDate(DateUtil.getTimeShort(amount.getTime()),
						new SimpleDateFormat(format).parse("12:00:00"),
						new SimpleDateFormat(format).parse("14:59:59"))) {
					DayData[4] = DayData[4] + 1;
				} else if (DateUtil.isEffectiveDate(DateUtil.getTimeShort(amount.getTime()),
						new SimpleDateFormat(format).parse("15:00:00"),
						new SimpleDateFormat(format).parse("17:59:59"))) {
					DayData[5] = DayData[5] + 1;
				} else if (DateUtil.isEffectiveDate(DateUtil.getTimeShort(amount.getTime()),
						new SimpleDateFormat(format).parse("18:00:00"),
						new SimpleDateFormat(format).parse("20:59:59"))) {
					DayData[6] = DayData[6] + 1;
				} else if (DateUtil.isEffectiveDate(DateUtil.getTimeShort(amount.getTime()),
						new SimpleDateFormat(format).parse("21:00:00"),
						new SimpleDateFormat(format).parse("23:59:59"))) {
					DayData[7] = DayData[7] + 1;
				}
			}
			map.put("time", Day);
			map.put("data", DayData);
			break;
		case 2:
			String Day7[] = { DateUtil.subDay(now, -6), DateUtil.subDay(now, -5), DateUtil.subDay(now, -4),
					DateUtil.subDay(now, -3), DateUtil.subDay(now, -2), DateUtil.subDay(now, -1),
					DateUtil.subDay(now, 0), };
			int Day7Data[] = { 0, 0, 0, 0, 0, 0, 0 };
			list = amountMapper.listBy7day();
			for (Amount amount : list) {
				if (DateUtils.isSameDay(amount.getTime(), DateUtil.subDayToDate(now, -6))) {
					Day7Data[0] = Day7Data[0] + 1;
				} else if (DateUtils.isSameDay(amount.getTime(), DateUtil.subDayToDate(now, -5))) {
					Day7Data[1] = Day7Data[1] + 1;
				} else if (DateUtils.isSameDay(amount.getTime(), DateUtil.subDayToDate(now, -4))) {
					Day7Data[2] = Day7Data[2] + 1;
				} else if (DateUtils.isSameDay(amount.getTime(), DateUtil.subDayToDate(now, -3))) {
					Day7Data[3] = Day7Data[3] + 1;
				} else if (DateUtils.isSameDay(amount.getTime(), DateUtil.subDayToDate(now, -2))) {
					Day7Data[4] = Day7Data[4] + 1;
				} else if (DateUtils.isSameDay(amount.getTime(), DateUtil.subDayToDate(now, -1))) {
					Day7Data[5] = Day7Data[5] + 1;
				} else if (DateUtils.isSameDay(amount.getTime(), DateUtil.subDayToDate(now, 0))) {
					Day7Data[6] = Day7Data[6] + 1;
				}
			}
			map.put("time", Day7);
			map.put("data", Day7Data);
			break;
		case 3:
			String Day30[] = { DateUtil.subDay(now, -29), DateUtil.subDay(now, -28), DateUtil.subDay(now, -27),
					DateUtil.subDay(now, -26), DateUtil.subDay(now, -25), DateUtil.subDay(now, -24),
					DateUtil.subDay(now, -23), DateUtil.subDay(now, -22), DateUtil.subDay(now, -21),
					DateUtil.subDay(now, -20), DateUtil.subDay(now, -19), DateUtil.subDay(now, -18),
					DateUtil.subDay(now, -17), DateUtil.subDay(now, -16), DateUtil.subDay(now, -15),
					DateUtil.subDay(now, -14), DateUtil.subDay(now, -13), DateUtil.subDay(now, -12),
					DateUtil.subDay(now, -11), DateUtil.subDay(now, -10), DateUtil.subDay(now, -9),
					DateUtil.subDay(now, -8), DateUtil.subDay(now, -7), DateUtil.subDay(now, -6),
					DateUtil.subDay(now, -5), DateUtil.subDay(now, -4), DateUtil.subDay(now, -3),
					DateUtil.subDay(now, -2), DateUtil.subDay(now, -1), DateUtil.subDay(now, 0) };
			int Day30Data[] = { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 };
			list = amountMapper.listBy7day();
			for (Amount amount : list) {
				if (DateUtils.isSameDay(amount.getTime(), DateUtil.subDayToDate(now, -29))) {
					Day30Data[0] = Day30Data[0] + 1;
				} else if (DateUtils.isSameDay(amount.getTime(), DateUtil.subDayToDate(now, -28))) {
					Day30Data[1] = Day30Data[1] + 1;
				} else if (DateUtils.isSameDay(amount.getTime(), DateUtil.subDayToDate(now, -27))) {
					Day30Data[2] = Day30Data[2] + 1;
				} else if (DateUtils.isSameDay(amount.getTime(), DateUtil.subDayToDate(now, -26))) {
					Day30Data[3] = Day30Data[3] + 1;
				} else if (DateUtils.isSameDay(amount.getTime(), DateUtil.subDayToDate(now, -25))) {
					Day30Data[4] = Day30Data[4] + 1;
				} else if (DateUtils.isSameDay(amount.getTime(), DateUtil.subDayToDate(now, -24))) {
					Day30Data[5] = Day30Data[5] + 1;
				} else if (DateUtils.isSameDay(amount.getTime(), DateUtil.subDayToDate(now, -23))) {
					Day30Data[6] = Day30Data[6] + 1;
				} else if (DateUtils.isSameDay(amount.getTime(), DateUtil.subDayToDate(now, -22))) {
					Day30Data[7] = Day30Data[7] + 1;
				} else if (DateUtils.isSameDay(amount.getTime(), DateUtil.subDayToDate(now, -21))) {
					Day30Data[8] = Day30Data[8] + 1;
				} else if (DateUtils.isSameDay(amount.getTime(), DateUtil.subDayToDate(now, -20))) {
					Day30Data[9] = Day30Data[9] + 1;
				} else if (DateUtils.isSameDay(amount.getTime(), DateUtil.subDayToDate(now, -19))) {
					Day30Data[10] = Day30Data[10] + 1;
				} else if (DateUtils.isSameDay(amount.getTime(), DateUtil.subDayToDate(now, -18))) {
					Day30Data[11] = Day30Data[11] + 1;
				} else if (DateUtils.isSameDay(amount.getTime(), DateUtil.subDayToDate(now, -17))) {
					Day30Data[12] = Day30Data[12] + 1;
				} else if (DateUtils.isSameDay(amount.getTime(), DateUtil.subDayToDate(now, -16))) {
					Day30Data[13] = Day30Data[13] + 1;
				} else if (DateUtils.isSameDay(amount.getTime(), DateUtil.subDayToDate(now, -15))) {
					Day30Data[14] = Day30Data[14] + 1;
				} else if (DateUtils.isSameDay(amount.getTime(), DateUtil.subDayToDate(now, -14))) {
					Day30Data[15] = Day30Data[15] + 1;
				} else if (DateUtils.isSameDay(amount.getTime(), DateUtil.subDayToDate(now, -13))) {
					Day30Data[16] = Day30Data[16] + 1;
				} else if (DateUtils.isSameDay(amount.getTime(), DateUtil.subDayToDate(now, -12))) {
					Day30Data[17] = Day30Data[17] + 1;
				} else if (DateUtils.isSameDay(amount.getTime(), DateUtil.subDayToDate(now, -11))) {
					Day30Data[18] = Day30Data[18] + 1;
				} else if (DateUtils.isSameDay(amount.getTime(), DateUtil.subDayToDate(now, -10))) {
					Day30Data[19] = Day30Data[19] + 1;
				} else if (DateUtils.isSameDay(amount.getTime(), DateUtil.subDayToDate(now, -9))) {
					Day30Data[20] = Day30Data[20] + 1;
				} else if (DateUtils.isSameDay(amount.getTime(), DateUtil.subDayToDate(now, -8))) {
					Day30Data[21] = Day30Data[21] + 1;
				} else if (DateUtils.isSameDay(amount.getTime(), DateUtil.subDayToDate(now, -7))) {
					Day30Data[22] = Day30Data[22] + 1;
				} else if (DateUtils.isSameDay(amount.getTime(), DateUtil.subDayToDate(now, -6))) {
					Day30Data[23] = Day30Data[23] + 1;
				} else if (DateUtils.isSameDay(amount.getTime(), DateUtil.subDayToDate(now, -5))) {
					Day30Data[24] = Day30Data[24] + 1;
				} else if (DateUtils.isSameDay(amount.getTime(), DateUtil.subDayToDate(now, -4))) {
					Day30Data[25] = Day30Data[25] + 1;
				} else if (DateUtils.isSameDay(amount.getTime(), DateUtil.subDayToDate(now, -3))) {
					Day30Data[26] = Day30Data[26] + 1;
				} else if (DateUtils.isSameDay(amount.getTime(), DateUtil.subDayToDate(now, -2))) {
					Day30Data[27] = Day30Data[27] + 1;
				} else if (DateUtils.isSameDay(amount.getTime(), DateUtil.subDayToDate(now, -1))) {
					Day30Data[28] = Day30Data[28] + 1;
				} else if (DateUtils.isSameDay(amount.getTime(), DateUtil.subDayToDate(now, -0))) {
					Day30Data[29] = Day30Data[29] + 1;
				}
			}
			map.put("time", Day30);
			map.put("data", Day30Data);
			break;
		}
		return map;
	}

	@Override
	public List<StatisticsVo> statistics() throws Exception {
		List<StatisticsVo> list = new LinkedList<>();
		StatisticsVo statisticsVo = new StatisticsVo();
		statisticsVo.setName("已留言");
		statisticsVo.setValue(messageMapper.total());
		list.add(statisticsVo);
		StatisticsVo statisticsVo1 = new StatisticsVo();
		statisticsVo1.setName("总浏览");
		statisticsVo1.setValue(amountMapper.total());
		list.add(statisticsVo1);
		return list;
	}

}
