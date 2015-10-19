package logic.Rules;

/**
 * Классически правила игры в Монополию
 * Created by user1 on 19.10.2015.
 */
public class ClassicRules extends Rules {

    public ClassicRules() {
        initialCash = 1500;
        salary = 200;
        incomeTaxFixed = 200;
        incomeTaxProportional = 10;
        luxuryTax = 75;
        jailPayment = 50;
        maxTurnsInJail = 3;
        freeParkingRent = 0;
        maxHouseNumber = 32;
        maxHotelNumber = 12;
    }
}
