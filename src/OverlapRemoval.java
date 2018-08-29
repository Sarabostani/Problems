import java.util.Arrays;
import java.util.Comparator;

public class OverlapRemoval {
	public static void run() {
		Interval[] intervals = { new Interval(1,2), new Interval(3,4), new Interval(2,3), new Interval(1,3) };
		Interval[] intervals2 = {new Interval(-100,-87),new Interval(-99,-44),new Interval(-98,-19),new Interval(-97,-33),new Interval(-96,-60),new Interval(-95,-17),new Interval(-94,-44),new Interval(-93,-9),new Interval(-92,-63),new Interval(-91,-76),new Interval(-90,-44),new Interval(-89,-18),new Interval(-88,10),new Interval(-87,-39),new Interval(-86,7),new Interval(-85,-76),new Interval(-84,-51),new Interval(-83,-48),new Interval(-82,-36),new Interval(-81,-63),new Interval(-80,-71),new Interval(-79,-4),new Interval(-78,-63),new Interval(-77,-14),new Interval(-76,-10),new Interval(-75,-36),new Interval(-74,31),new Interval(-73,11),new Interval(-72,-50),new Interval(-71,-30),new Interval(-70,33),new Interval(-69,-37),new Interval(-68,-50),new Interval(-67,6),new Interval(-66,-50),new Interval(-65,-26),new Interval(-64,21),new Interval(-63,-8),new Interval(-62,23),new Interval(-61,-34),new Interval(-60,13),new Interval(-59,19),new Interval(-58,41),new Interval(-57,-15),new Interval(-56,35),new Interval(-55,-4),new Interval(-54,-20),new Interval(-53,44),new Interval(-52,48),new Interval(-51,12),new Interval(-50,-43),new Interval(-49,10),new Interval(-48,-34),new Interval(-47,3),new Interval(-46,28),new Interval(-45,51),new Interval(-44,-14),new Interval(-43,59),new Interval(-42,-6),new Interval(-41,-32),new Interval(-40,-12),new Interval(-39,33),new Interval(-38,17),new Interval(-37,-7),new Interval(-36,-29),new Interval(-35,24),new Interval(-34,49),new Interval(-33,-19),new Interval(-32,2),new Interval(-31,8),new Interval(-30,74),new Interval(-29,58),new Interval(-28,13),new Interval(-27,-8),new Interval(-26,45),new Interval(-25,-5),new Interval(-24,45),new Interval(-23,19),new Interval(-22,9),new Interval(-21,54),new Interval(-20,1),new Interval(-19,81),new Interval(-18,17),new Interval(-17,-10),new Interval(-16,7),new Interval(-15,86),new Interval(-14,-3),new Interval(-13,-3),new Interval(-12,45),new Interval(-11,93),new Interval(-10,84),new Interval(-9,20),new Interval(-8,3),new Interval(-7,81),new Interval(-6,52),new Interval(-5,67),new Interval(-4,18),new Interval(-3,40),new Interval(-2,42),new Interval(-1,49),new Interval(0,7),new Interval(1,104),new Interval(2,79),new Interval(3,37),new Interval(4,47),new Interval(5,69),new Interval(6,89),new Interval(7,110),new Interval(8,108),new Interval(9,19),new Interval(10,25),new Interval(11,48),new Interval(12,63),new Interval(13,94),new Interval(14,55),new Interval(15,119),new Interval(16,64),new Interval(17,122),new Interval(18,92),new Interval(19,37),new Interval(20,86),new Interval(21,84),new Interval(22,122),new Interval(23,37),new Interval(24,125),new Interval(25,99),new Interval(26,45),new Interval(27,63),new Interval(28,40),new Interval(29,97),new Interval(30,78),new Interval(31,102),new Interval(32,120),new Interval(33,91),new Interval(34,107),new Interval(35,62),new Interval(36,137),new Interval(37,55),new Interval(38,115),new Interval(39,46),new Interval(40,136),new Interval(41,78),new Interval(42,86),new Interval(43,106),new Interval(44,66),new Interval(45,141),new Interval(46,92),new Interval(47,132),new Interval(48,89),new Interval(49,61),new Interval(50,128),new Interval(51,155),new Interval(52,153),new Interval(53,78),new Interval(54,114),new Interval(55,84),new Interval(56,151),new Interval(57,123),new Interval(58,69),new Interval(59,91),new Interval(60,89),new Interval(61,73),new Interval(62,81),new Interval(63,139),new Interval(64,108),new Interval(65,165),new Interval(66,92),new Interval(67,117),new Interval(68,140),new Interval(69,109),new Interval(70,102),new Interval(71,171),new Interval(72,141),new Interval(73,117),new Interval(74,124),new Interval(75,171),new Interval(76,132),new Interval(77,142),new Interval(78,107),new Interval(79,132),new Interval(80,171),new Interval(81,104),new Interval(82,160),new Interval(83,128),new Interval(84,137),new Interval(85,176),new Interval(86,188),new Interval(87,178),new Interval(88,117),new Interval(89,115),new Interval(90,140),new Interval(91,165),new Interval(92,133),new Interval(93,114),new Interval(94,125),new Interval(95,135),new Interval(96,144),new Interval(97,114),new Interval(98,183),new Interval(99,157)};
		System.out.println(eraseOverlapIntervals(intervals));
		System.out.println(eraseOverlapIntervals(intervals2));
		
	}
	public static int eraseOverlapIntervals(Interval[] intervals) {
        
        Arrays.sort(intervals, new Comparator<Interval>() {
        	@Override
        	public int compare(Interval a, Interval b) {
        		return a.end - b.end;
        	}
        });
        
        int i = 0;
        int j = 1;
        int count = 0;
        while (j < intervals.length) {
        	if (intervals[j].start < intervals[i].end) {
        		count++; j++;
        	}
        	else {
        		i = j;
        		j += 1;
        	}
        }
        
        return count;
        
    }
}
