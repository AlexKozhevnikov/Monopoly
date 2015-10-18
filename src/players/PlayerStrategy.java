package players;

import logic.JailDecision;

/**
 * Интерфейс определяет обязательные действия, которые должен предпринимать любой игрок в игровых ситуациях
 * Created by user1 on 18.10.2015.
 */
public interface PlayerStrategy {

    /**
     * Метод возвращает решение, оставаться ли игроку в тюрьме или выходить
     * @return jailDecision
     */
    public JailDecision stayInJail();

    /**
     * Метод определяет, платить $200 при попадании на поле Income Tax, или 10% от имущества
     * @return true, если принято решение платить $200
     */
    public boolean IncomeTax200();

    /**
     * Метод определяет, брать ли собственность, на которую попал игрок, или же выставить на аукцион
     * @param card
     * @return
     */
    public boolean takeProperty(int card);

    public int auction(int property, int sum);

    public boolean winMoney();

    public boolean acceptTrade(Trade td);

    public void doAnyActions();
}
