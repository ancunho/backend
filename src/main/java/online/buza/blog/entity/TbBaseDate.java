package online.buza.blog.entity;

public class TbBaseDate {
    private String baseYmd;

    private String baseYyyy;

    private String baseMm;

    private String baseDd;

    private String baseWeekday;

    private String baseWeekdayName;

    private String baseWw;

    private String lunarYmd;

    private String holidayYn;

    private String holidayName;

    private String useYn;

    private String memo;

    private String option01;

    private String option02;

    private String option03;

    private String option04;

    private String option05;

    public String getBaseYmd() {
        return baseYmd;
    }

    public void setBaseYmd(String baseYmd) {
        this.baseYmd = baseYmd;
    }

    public String getBaseYyyy() {
        return baseYyyy;
    }

    public void setBaseYyyy(String baseYyyy) {
        this.baseYyyy = baseYyyy;
    }

    public String getBaseMm() {
        return baseMm;
    }

    public void setBaseMm(String baseMm) {
        this.baseMm = baseMm;
    }

    public String getBaseDd() {
        return baseDd;
    }

    public void setBaseDd(String baseDd) {
        this.baseDd = baseDd;
    }

    public String getBaseWeekday() {
        return baseWeekday;
    }

    public void setBaseWeekday(String baseWeekday) {
        this.baseWeekday = baseWeekday;
    }

    public String getBaseWeekdayName() {
        return baseWeekdayName;
    }

    public void setBaseWeekdayName(String baseWeekdayName) {
        this.baseWeekdayName = baseWeekdayName;
    }

    public String getBaseWw() {
        return baseWw;
    }

    public void setBaseWw(String baseWw) {
        this.baseWw = baseWw;
    }

    public String getLunarYmd() {
        return lunarYmd;
    }

    public void setLunarYmd(String lunarYmd) {
        this.lunarYmd = lunarYmd;
    }

    public String getHolidayYn() {
        return holidayYn;
    }

    public void setHolidayYn(String holidayYn) {
        this.holidayYn = holidayYn;
    }

    public String getHolidayName() {
        return holidayName;
    }

    public void setHolidayName(String holidayName) {
        this.holidayName = holidayName;
    }

    public String getUseYn() {
        return useYn;
    }

    public void setUseYn(String useYn) {
        this.useYn = useYn;
    }

    public String getMemo() {
        return memo;
    }

    public void setMemo(String memo) {
        this.memo = memo;
    }

    public String getOption01() {
        return option01;
    }

    public void setOption01(String option01) {
        this.option01 = option01;
    }

    public String getOption02() {
        return option02;
    }

    public void setOption02(String option02) {
        this.option02 = option02;
    }

    public String getOption03() {
        return option03;
    }

    public void setOption03(String option03) {
        this.option03 = option03;
    }

    public String getOption04() {
        return option04;
    }

    public void setOption04(String option04) {
        this.option04 = option04;
    }

    public String getOption05() {
        return option05;
    }

    public void setOption05(String option05) {
        this.option05 = option05;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", baseYmd=").append(baseYmd);
        sb.append(", baseYyyy=").append(baseYyyy);
        sb.append(", baseMm=").append(baseMm);
        sb.append(", baseDd=").append(baseDd);
        sb.append(", baseWeekday=").append(baseWeekday);
        sb.append(", baseWeekdayName=").append(baseWeekdayName);
        sb.append(", baseWw=").append(baseWw);
        sb.append(", lunarYmd=").append(lunarYmd);
        sb.append(", holidayYn=").append(holidayYn);
        sb.append(", holidayName=").append(holidayName);
        sb.append(", useYn=").append(useYn);
        sb.append(", memo=").append(memo);
        sb.append(", option01=").append(option01);
        sb.append(", option02=").append(option02);
        sb.append(", option03=").append(option03);
        sb.append(", option04=").append(option04);
        sb.append(", option05=").append(option05);
        sb.append("]");
        return sb.toString();
    }
}