
import static java.lang.System.out;
import java.text.SimpleDateFormat;
import java.util.*;

public class Flight {

	private String startPlace, arrivePlace;
	private Date startTime;
	public Airplane air;
	public static List<Flight> lFlight=new ArrayList<>();

	Flight(String startPlace, String arrivePlace, Date startTime, Airplane air) {
		this.startPlace = startPlace;
		this.arrivePlace = arrivePlace;
		this.startTime = startTime;
		this.air = air;
	}

	public String getStartPlace() {
		return startPlace;
	}

	public void setStartPlace(String startPlace) {
		this.startPlace = startPlace;
	}

	public String getArrivePlace() {
		return arrivePlace;
	}

	public void setArrivePlace(String arrivePlace) {
		this.arrivePlace = arrivePlace;
	}

	public Date getStartTime() {
		return startTime;
	}
	public String toString() {
		Date date = startTime;
		//設定日期格式
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		//進行轉換
		String dateString = sdf.format(date);
		
		//System.out.println(dateString);
		return air.id+","+air.firstClass+","+air.bussinessClass+","+air.economyClass+","+dateString.toString()+","+startPlace+","+arrivePlace;
	}
	public void setStartTime(Date startTime) {
		this.startTime = startTime;
	}
	public static List<Flight> getNode() { 
		return lFlight; 
	}
	/*
	 * public List<Flight> getNode() { return node; } public void
	 * setNode(List<Flight> node) { this.node = node; }
	 */

	public static void createFlight(String createID, String createFirstClass, String createEconomyClass,
			String createBussinessClass, String createDateYear, String createDateMonth, String createDateDay,
			String createDateHour, String createDateMinute, String createStartPlace, String createArrivePlace)
			throws Exception {
		int tmpCreateFirstClass = Integer.parseInt(createFirstClass);
		int tmpCreateEconomyClass = Integer.parseInt(createEconomyClass);
		int tmpCreateBussinessClass = Integer.parseInt(createBussinessClass);

		StringBuilder sbTmpDate = new StringBuilder();
		sbTmpDate.append(createDateYear).append("-").append(createDateMonth).append("-").append(createDateDay)
				.append(" ").append(createDateHour).append(":").append(createDateMinute);
		String sDate = sbTmpDate.toString();
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd hh:mm");
		Date tmpDate = formatter.parse(sDate);
		// 輸出Date參考
		// name+","+thing+","+(date.getYear()+1900)+"/"+(date.getMonth()+1)+"/"+date.getDate()+"
		// "+date.getHours()+":"+date.getMinutes()+":"+date.getSeconds()+","+site;

		/*
		 * 讀檔Date參考 Date now, tmpDate; int tmpWeek, tmpMonth, tmpDay, tmpHour,
		 * tmpMinute, tmpSecond;
		 * 
		 * this.name = name; this.thing = thing; this.date = new Date(date); this.site =
		 * site;
		 * 
		 * String[] dateSp = date.trim().split("\\s+|/|:"); now = new Date(date);
		 * tmpDate = new Date("2018/"+dateSp[1]+"/1 0:0");
		 * 
		 * this.month = now.getMonth()+1; this.day = Integer.valueOf(dateSp[2]);
		 * this.hour = now.getHours(); this.minute = now.getMinutes(); this.second =
		 * now.getSeconds();
		 * 
		 * this.week = (int)((now.getTime() - tmpDate.getTime())/1000/60/60/24/7) + 1;
		 */
		Airplane tmpAirplane = new Airplane();
		tmpAirplane.id = createID;
		tmpAirplane.firstClass = tmpCreateFirstClass;
		tmpAirplane.economyClass = tmpCreateEconomyClass;
		tmpAirplane.bussinessClass = tmpCreateBussinessClass;
		Flight tmpFlight = new Flight(createStartPlace, createArrivePlace, tmpDate, tmpAirplane);

		lFlight.add(tmpFlight);
	}

	public static void deleteFlight(String deleteKey) {
		//String[] spTmpKey = deleteKey.split("\\s+");
		for(Flight f:lFlight) {
			if(deleteKey.equals(f.toString())) {
				lFlight.remove(f);
			}
		}
	}

	public void modifyFlight(String modifyKey, String createID, String createFirstClass, String createEconomyClass,
			String createBussinessClass, String createDateYear, String createDateMonth, String createDateDay,
			String createDateHour, String createDateMinute, String createStartPlace, String createArrivePlace)throws Exception{
		deleteFlight(modifyKey);
		createFlight(createID, createFirstClass, createEconomyClass, createBussinessClass, createDateYear, createDateMonth, createDateDay, createDateHour, createDateMinute, createStartPlace, createArrivePlace);
	}

	public List<String> searchFlight(String searchKey) {
		List<String> findFlight = new ArrayList<>();
		for (Flight f : lFlight) {
			if (searchKey.equals(f.getArrivePlace())) {
				StringBuilder sbTmpFind = new StringBuilder();
				sbTmpFind.append(f.air.id)
				.append("/t").append(f.getStartPlace())
				.append("/t").append(f.getArrivePlace())
				.append("/t").append(f.air.firstClass)
				.append("/t").append(f.air.economyClass)
				.append("/t").append(f.air.bussinessClass)
				.append("/t").append(f.getStartTime().getYear() + 1900)
				.append("-").append(f.getStartTime().getMonth() + 1)
				.append("-").append(f.getStartTime().getDate())
				.append(" ").append(f.getStartTime().getHours())
				.append(":").append(f.getStartTime().getMinutes());
				String sFind = sbTmpFind.toString();
				findFlight.add(sFind);
			}
		}
		return findFlight;
	}
}
