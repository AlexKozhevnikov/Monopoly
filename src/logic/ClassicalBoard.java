package logic;

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
        fields[12] = ClassicField.States;
        fields[13] = ClassicField.Virginia;
        fields[14] = ClassicField.PennsylvaniaRailroad;
        fields[15] = ClassicField.;
        fields[16] = ClassicField.CommunityChest1;
        fields[17] = ClassicField.Mediterannean;
        fields[18] = ClassicField.CommunityChest1;
        fields[19] = ClassicField.Mediterannean;
        fields[20] = ClassicField.CommunityChest1;



    }

    public ClassicField[] getFields() {
        return fields;
    }

    public ClassicField getField(int id) {
        return fields[id];
    }
}
