package logic;

/**
 * ����� ���������� ��� ����, �� �������� � ��������� � ������������ ���������
 * Created by user1 on 18.10.2015.
 */
public enum ClassicField {

    Go(0, FieldType.other),
    Mediterannean(1, FieldType.property, ColorGroup.violet, 60, 2, 10, 30, 90, 160, 250),
    CommunityChest1(2, FieldType.communityChest),
    Baltic(3, FieldType.property, ColorGroup.violet, 60, 4, 20, 60, 180, 320, 450),
    IncomeTax(4, FieldType.action),
    ReadingRailroad(5, FieldType.railroad, 200),
    Oriental(6, FieldType.property, ColorGroup.lightBlue, 100, 6, 30, 90, 270, 400, 550),
    Chance1(7, FieldType.chance),
    Vermont(8, FieldType.property, ColorGroup.lightBlue, 100, 6, 30, 90, 270, 400, 550),
    Connecticut(9, FieldType.property, ColorGroup.lightBlue, 120, 8, 40, 100, 300, 450, 600),
    JustVisitingJail(10, FieldType.other),
    StCharles(11, FieldType.property, ColorGroup.magenta, 140, 10, 50, 150, 450, 625, 750),
    ElectricCompany(12, FieldType.utility, 150),
    States(13, FieldType.property, ColorGroup.magenta, 140, 10, 50, 150, 450, 625, 750),
    Virginia(14, FieldType.property, ColorGroup.magenta, 160, 12, 60, 180, 500, 700, 900),
    PennsylvaniaRailroad(15, FieldType.railroad, 200),
    StJames(16, FieldType.property, ColorGroup.orange, 180, 14, 70, 200, 550, 750, 950),
    CommunityChest2(17, FieldType.communityChest),
    Tennessee(18, FieldType.property, ColorGroup.orange, 180, 14, 70, 200, 550, 750, 950),
    NewYork(19, FieldType.property, ColorGroup.orange, 200, 16, 80, 220, 600, 800, 1000),
    FreeParking(20, FieldType.other),
    Kentucky(21, FieldType.property, ColorGroup.red, 220, 18, 90, 250, 700, 875, 1050),
    Chance2(22, FieldType.chance),
    Indiana(23, FieldType.property, ColorGroup.red, 220, 18, 90, 250, 700, 875, 1050),
    Illinois(24, FieldType.property, ColorGroup.red, 240, 20, 100, 300, 750, 925, 1100),
    BORailroad(25, FieldType.railroad, 200),
    Atlantic(26, FieldType.property, ColorGroup.yellow, 260, 22, 110, 330, 800, 975, 1150),
    Ventnor(27, FieldType.property, ColorGroup.yellow, 260, 22, 110, 330, 800, 975, 1150),
    WaterWorks(28, FieldType.utility, 150),
    MarvinGardens(29, FieldType.property, ColorGroup.yellow, 280, 24, 120, 360, 850, 1025, 1200),
    GoToJail(30, FieldType.action),
    Pacific(31, FieldType.property, ColorGroup.green, 300, 26, 130, 390, 900, 1100, 1275),
    NorthCarolina(32, FieldType.property, ColorGroup.green, 300, 26, 130, 390, 900, 1100, 1275),
    CommunityChest3(33, FieldType.communityChest),
    Pennsylvania(34, FieldType.property, ColorGroup.green, 320, 28, 150, 450, 1000, 1200, 1400),
    ShortLineRailroad(35, FieldType.railroad, 200),
    Chance3(36, FieldType.chance),
    ParkPlace(37, FieldType.property, ColorGroup.blue, 350, 35, 175, 500, 1100, 1300, 1500),
    LuxuryTax(38, FieldType.action),
    BroadWalk(39, FieldType.property, ColorGroup.blue, 400, 50, 200, 600, 1400, 1700, 2000),
    Jail(40, FieldType.other);

    /**
     * ������������� ����, ����������� � ��� ������� �� �����
     */
    private final int id;
    /**
     * ��� ����
     */
    private final FieldType fieldType;
    /**
     * �������� ������ ����. ���������, ������ ���� ��� ���� - ������������� (property)
     */
    private ColorGroup colorGroup;
    /**
     * ���� ����. �����������, ������ ���� ���� ������ ��������, ����� - null
     */
    private Integer price;
    /**
     * �����, ������������� ��������� ��� ��������� �� ����, ���� � ��������� ��� ��������� �� �������� ������
     */
    private Integer baseCost;
    /**
     * �����, ������������� ��������� ��� ��������� �� ����, ���� � ��������� ���� �� �� ���� ���
     */
    private Integer oneHouseCost;
    /**
     * �����, ������������� ��������� ��� ��������� �� ����, ���� � ��������� ���� �� �� ��� ����
     */
    private Integer twoHouseCost;
    /**
     * �����, ������������� ��������� ��� ��������� �� ����, ���� � ��������� ���� �� �� ��� ����
     */
    private Integer threeHouseCost;
    /**
     * �����, ������������� ��������� ��� ��������� �� ����, ���� � ��������� ���� �� �� ������ ����
     */
    private Integer fourHouseCost;
    /**
     * �����, ������������� ��������� ��� ��������� �� ����, ���� � ��������� ���� �� �� �����
     */
    private Integer hotelCost;

    /**
     * ��������� ������������ ���������
     */
    private Integer mortgageValue;
    /**
     * �����, ������������� ��������� ��� ��������� �� ����, ���� � ��������� ���� ��������� �� �������� ������,
     * �� ��� ����� � ������
     */
    private Integer monopolyCost;

    /**
     * ����������� ��� ����� ���� "�������������" (property)
     * @param id             ������������� ����
     * @param fieldType      ��� ����
     * @param colorGroup     �������� ������
     * @param price          ���� ����
     * @param baseCost       ��������� ��������� ��� ���������
     * @param oneHouseCost   ��������� ��������� � ����� �����
     * @param twoHouseCost   ��������� ��������� � ����� ������
     * @param threeHouseCost ��������� ��������� � ����� ������
     * @param fourHouseCost  ��������� ��������� � �������� ������
     * @param hotelCost      ��������� ��������� � ������
     */
    ClassicField(int id, FieldType fieldType, ColorGroup colorGroup, int price, int baseCost, int oneHouseCost,
                 int twoHouseCost, int threeHouseCost, int fourHouseCost, int hotelCost) {
        this.id = id;
        this.fieldType = fieldType;
        this.colorGroup = colorGroup;
        this.price = price;
        this.baseCost = baseCost;
        this.oneHouseCost = oneHouseCost;
        this.twoHouseCost = twoHouseCost;
        this.threeHouseCost = threeHouseCost;
        this.fourHouseCost = fourHouseCost;
        this.hotelCost = hotelCost;
        monopolyCost = baseCost * 2;
        setMortgageValue();
    }

    /**
     * ����������� ��� railway � communal
     * @param id        ������������� ����
     * @param fieldType ��� ����
     */
    ClassicField(int id, FieldType fieldType, int price) {
        this.id = id;
        this.fieldType = fieldType;
        this.price = price;
        setMortgageValue();
    }

    /**
     * ����������� ��� �����, �� ����������� ��������������
     * @param id        ������������� ����
     * @param fieldType ��� ����
     */
    ClassicField(int id, FieldType fieldType) {
        this.id = id;
        this.fieldType = fieldType;
    }

    private void setMortgageValue() {
        mortgageValue = price / 2;
    }

    // getters

    public int getId() {
        return id;
    }

    public FieldType getFieldType() {
        return fieldType;
    }

    public ColorGroup getColorGroup() {
        return colorGroup;
    }

    public Integer getPrice() {
        return price;
    }

    public Integer getBaseCost() {
        return baseCost;
    }

    public Integer getOneHouseCost() {
        return oneHouseCost;
    }

    public Integer getTwoHouseCost() {
        return twoHouseCost;
    }

    public Integer getThreeHouseCost() {
        return threeHouseCost;
    }

    public Integer getFourHouseCost() {
        return fourHouseCost;
    }

    public Integer getHotelCost() {
        return hotelCost;
    }

    public Integer getMortgageValue() {
        return mortgageValue;
    }

    public Integer getMonopolyCost() {
        return monopolyCost;
    }
}
