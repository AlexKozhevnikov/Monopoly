package players;

import action.Game;
import logic.TradeProposition;
import logic.enums.ClassicField;
import logic.enums.JailDecision;

import java.lang.reflect.Field;

/**
 * ��������� ���������� ������������ ��������, ������� ������ ������������� ����� ����� � ������� ���������
 * Created by user1 on 18.10.2015.
 */
public abstract class PlayerStrategy {

    /**
     * ������ �� ������ ������ "����", � ������� �������� ���������� ������� ������
     */
    protected Game game;
    /**
     * ����������� ����� � ����
     */
    protected int self;

    /**
     * ����� ���������� ��� ������
     * @return ��� ������
     */
    public abstract String getName();

    /**
     * ����� ���������� �������, ���������� �� ������ � ������ ��� ��������
     * @return jailDecision
     */
    public abstract JailDecision stayInJail();

    /**
     * ����� ����������, ������� ��� ��������� �� ���� Income Tax, ������������� �����, ��� ������� �� ���������
     * @return true, ���� ������� ������� ������� ������������� �����
     */
    public abstract boolean chooseIncomeTaxFix();

    /**
     * ����� ����������, ����������� �� ����, �� ������� ����� �����, ��� �� ��������� �� �������
     * @param field ����, �� ������� ����� �����
     * @return {@code true}, ���� ������� ������� ���������� ����
     */
    public abstract boolean takeProperty(ClassicField field);

    /**
     * ����� ����������, ����� ����� ��������� �� �������� � ���� ���
     * @param field ����, ������� ������������� �� ��������
     * @param sum   ������� ����� �����������
     * @return �������� �������� �����, �� ������� ������� �������, ���� ����� ����� ���������� ������� � ��������,
     *         null, ���� ����� ��������� �� ������� � ��������
     */
    public abstract Integer auction(ClassicField field, int sum);

    /**
     * ����� ����������, ����� � ������ ��������� �������. ���������� ���������� ��-�� ��� ������ ������, � � �����
     * ���� ������ ������ ����� ���������������
     * @return {@code true}, ���� ������ ������� ����� � "����", {@code false}, ���� �� �������
     */
    public abstract boolean winMoney();

    /**
     * ����� ����������, ����� ������ ���������� ��������. ����� ������������� ����������� � ����������, ��������� ���
     * ��� ���������
     * @param tradeProposition �������� �����������
     * @return {@code true}, ���� ����� ���������� �� ������ �����������
     */
    public abstract boolean acceptTrade(TradeProposition tradeProposition);

    /**
     * ����� ���������� � ����� ���� ������ � �������� ������������ ���-������ ������� ����������, ��������, ���������
     * ����, �����, ����������� � ���-������ ��� ��������������
     */
    public abstract void doAnyActions();

    /**
     * ����� ������������� ����������-������ �� ��������� ������� ����
     * @param game ������ "����"
     */
    public void setGame(Game game) {
        this.game = game;
    }

    public void setSelf(int number) {
        self = number;
    }
}
