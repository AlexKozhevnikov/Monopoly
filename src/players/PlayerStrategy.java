package players;

import logic.JailDecision;

/**
 * ��������� ���������� ������������ ��������, ������� ������ ������������� ����� ����� � ������� ���������
 * Created by user1 on 18.10.2015.
 */
public interface PlayerStrategy {

    /**
     * ����� ���������� �������, ���������� �� ������ � ������ ��� ��������
     * @return jailDecision
     */
    public JailDecision stayInJail();

    /**
     * ����� ����������, ������� $200 ��� ��������� �� ���� Income Tax, ��� 10% �� ���������
     * @return true, ���� ������� ������� ������� $200
     */
    public boolean IncomeTax200();

    /**
     * ����� ����������, ����� �� �������������, �� ������� ����� �����, ��� �� ��������� �� �������
     * @param card
     * @return
     */
    public boolean takeProperty(int card);

    public int auction(int property, int sum);

    public boolean winMoney();

    public boolean acceptTrade(Trade td);

    public void doAnyActions();
}
