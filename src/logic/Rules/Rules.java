package logic.Rules;

/**
 * »нтерфейс, определ€ющий об€зательные параметры и правила игры
 * Created by user1 on 19.10.2015.
 */
public abstract class Rules {

    protected static int initialCash;

    protected static int salary;

    protected static int incomeTaxFixed;

    protected static int incomeTaxProportional;

    protected static int jailPayment;

    protected static short maxTurnsInJail;

    protected static int freeParkingRent;

    protected static int luxuryTax;

    protected static int maxHouseNumber;

    protected static int maxHotelNumber;

    public static int getInitialCash() {

        return initialCash;
    }

    public static int getSalary() {
        return salary;
    }

    public static int getIncomeTaxFixed() {
        return incomeTaxFixed;
    }

    public static float getIncomeTaxProportional() {
        return incomeTaxProportional;
    }

    public static int getJailPayment() {
        return jailPayment;
    }

    public static short getMaxTurnsInJail() {
        return maxTurnsInJail;
    }

    public static int getFreeParkingRent() {
        return freeParkingRent;
    }

    public static int getLuxuryTax() {
        return luxuryTax;
    }

    public static int getMaxHouseNumber() {
        return maxHouseNumber;
    }

    public static int getMaxHotelNumber() {
        return maxHotelNumber;
    }
}
