package logic.exceptions;

/**
 * ����������, ������� �������������, ���� � ����-�� �� ������� ���������� ������������� ������
 * Created by user1 on 19.10.2015.
 */
public class NegativeBalanceException extends Exception {
    private int player;

    public NegativeBalanceException(int player) {
        this.player = player;
    }

    public int getPlayer() {
        return player;
    }

}
