package logic.enums;

/**
 * �����, ����������� ��������� ���� ����� �������� ����
 * Created by user1 on 18.10.2015.
 */
public enum FieldType {
    /**
     * ������������ ������ (2 ��.)
     */
    utility,
    /**
     * �������� ������ (4 ��.)
     */
    railroad,
    /**
     * ����� ������������� (22 ��.)
     */
    property,
    /**
     * ���� (3 ��.)
     */
    chance,
    /**
     * ������ (2 ��.)
     */
    communityChest,
    /**
     * �����, ��� ��������� �� ������� ����� ���������� ���-�� �������:
     * 1) Income Tax,
     * 2) Go To Jail,
     * 3)Luxury Tax
     */
    action,
    /**
     * ������ �����:
     * 1) Go
     * 2) Just visiting jail
     * 3) Free Parking
     */
    other
}
