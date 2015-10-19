package action;

import desktopUtility.Application;
import logic.Rules.Rules;
import logic.exceptions.NegativeBalanceException;
import players.PlayerStrategy;

/**
 * Created by user1 on 18.10.2015.
 */
public class Game {

    private static Game instance;
    /**
     * ���������� �������
     */
    private int numberOfPlayers;
    /**
     * ����� �������
     */
    private String playerName[];
    /**
     * ������� �������
     */
    private int cash[];
    /**
     * ������� ����, ��� ����� �������
     */
    private boolean defeated[];
    /**
     * ���������� ���� ����������� ������ �� ������
     */
    private int jailCard[];
    /**
     * API �������, ����� ������� ���������� ��������� �� �������
     */
    private PlayerStrategy playerStrategyInterface[];

    private Game(int numberOfPlayers, PlayerStrategy[] playerStrategies) throws Exception {
        this.numberOfPlayers = numberOfPlayers;
        if (playerStrategies.length != numberOfPlayers) {
            throw new Exception();
        }
        playerStrategyInterface = playerStrategies;
        playerName = new String[numberOfPlayers];
        defeated = new boolean[numberOfPlayers];
        cash = new int[numberOfPlayers];
        jailCard = new int[numberOfPlayers];
        for (int player = 0; player < numberOfPlayers; player++) {
            playerName[player] = playerStrategyInterface[player].getName();
            playerStrategyInterface[player].setSelf(player);
            playerStrategyInterface[player].setGame(instance);
        }
    }

    public static synchronized Game getInstance(int numberOfPlayers, PlayerStrategy[] playerStrategies) throws Exception {
        if (instance == null) {
            instance = new Game(numberOfPlayers, playerStrategies);
        }
        return instance;
    }

    public boolean hasJailCard(int player) {
        return jailCard[player] > 0;
    }

    /**
     * ����� �������� ������� ������������ ������ �� ����������� �����, ������������� ��� �������������
     * @param player ����� ������
     * @param sum    ��������� �����
     */
    private void changeCash(int player, int sum) throws NegativeBalanceException {
        cash[player] += sum;
        if (cash[player] < 0) {
            throw new NegativeBalanceException(player);
        }
    }

    // getters and setters

    public int getNumberOfPlayers() {
        return numberOfPlayers;
    }

    public String getPlayerName(int player) {
        return playerName[player];
    }

    public int getCash(int player) {
        return cash[player];
    }

    public boolean getDefeated(int player) {
        return defeated[player];
    }

    public Rules getRules () {
        return Application.getRules();
    }
}
