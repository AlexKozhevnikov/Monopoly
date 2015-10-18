package logic;

/**
 * ������������ ��������� �������� �����
 * Created by user1 on 18.10.2015.
 */
public enum ColorGroup {
    violet(1),
    lightBlue(2),
    magenta(3),
    orange(4),
    red(5),
    yellow(6),
    green(7),
    blue(8);

    /**
     * ������������� �������� ������
     */
    private final int id;

    /**
     * ��������� ��������� ���� ��� ����� ��� ������ �������� ������
     */
    private final int houseCost;

    ColorGroup (int colorGroupId) {
        id = colorGroupId;
        houseCost = (id - 1) / 2 * 50;
    }

    public int getHouseCost() {
        return houseCost;
    }

    public int getId() {
        return id;
    }
}
