package logic;

import logic.enums.ClassicField;

/**
 * Класс является хранилищем полей стандартной монополии (без учёта переменных конкретной партии)
 * Created by user1 on 18.10.2015.
 */
public class ClassicalBoard {
    /**
     * Массив с полями
     */
    final private ClassicField[] fields;

    public ClassicalBoard() {
        // 41 - потому что 40 игровых полей и ещё одно воображаемое - тюрьма
        fields = new ClassicField[41];

        fields[0] = ClassicField.Go;
        fields[1] = ClassicField.Mediterannean;
        fields[2] = ClassicField.CommunityChest1;
        fields[3] = ClassicField.Baltic;
        fields[4] = ClassicField.IncomeTax;
        fields[5] = ClassicField.ReadingRailroad;
        fields[6] = ClassicField.Oriental;
        fields[7] = ClassicField.Chance1;
        fields[8] = ClassicField.Vermont;
        fields[9] = ClassicField.Connecticut;
        fields[10] = ClassicField.JustVisitingJail;
        fields[11] = ClassicField.StCharles;
        fields[12] = ClassicField.ElectricCompany;
        fields[13] = ClassicField.States;
        fields[14] = ClassicField.Virginia;
        fields[15] = ClassicField.PennsylvaniaRailroad;
        fields[16] = ClassicField.StJames;
        fields[17] = ClassicField.CommunityChest2;
        fields[18] = ClassicField.Tennessee;
        fields[19] = ClassicField.NewYork;
        fields[20] = ClassicField.FreeParking;
        fields[21] = ClassicField.Kentucky;
        fields[22] = ClassicField.Chance2;
        fields[23] = ClassicField.Indiana;
        fields[24] = ClassicField.Illinois;
        fields[25] = ClassicField.BORailroad;
        fields[26] = ClassicField.Atlantic;
        fields[27] = ClassicField.Ventnor;
        fields[28] = ClassicField.WaterWorks;
        fields[29] = ClassicField.MarvinGardens;
        fields[30] = ClassicField.GoToJail;
        fields[31] = ClassicField.Pacific;
        fields[32] = ClassicField.NorthCarolina;
        fields[33] = ClassicField.CommunityChest3;
        fields[34] = ClassicField.Pennsylvania;
        fields[35] = ClassicField.ShortLineRailroad;
        fields[36] = ClassicField.Chance3;
        fields[37] = ClassicField.ParkPlace;
        fields[38] = ClassicField.LuxuryTax;
        fields[39] = ClassicField.BroadWalk;
        fields[40] = ClassicField.Jail;
    }

    public ClassicField[] getFields() {
        return fields;
    }

    public ClassicField getField(int id) {
        return fields[id];
    }
}
