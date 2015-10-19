package players;

import action.Game;
import logic.TradeProposition;
import logic.enums.ClassicField;
import logic.enums.JailDecision;

import java.lang.reflect.Field;

/**
 * Интерфейс определяет обязательные действия, которые должен предпринимать любой игрок в игровых ситуациях
 * Created by user1 on 18.10.2015.
 */
public abstract class PlayerStrategy {

    /**
     * Ссылка на объект класса "игра", в котором хранятся переменные текущей партии
     */
    protected Game game;
    /**
     * Собственный номер в игре
     */
    protected int self;

    /**
     * Метод возвращает имя игрока
     * @return имя игрока
     */
    public abstract String getName();

    /**
     * Метод возвращает решение, оставаться ли игроку в тюрьме или выходить
     * @return jailDecision
     */
    public abstract JailDecision stayInJail();

    /**
     * Метод определяет, платить при попадании на поле Income Tax, фиксированный налог, или процент от имущества
     * @return true, если принято решение платить фиксированный налог
     */
    public abstract boolean chooseIncomeTaxFix();

    /**
     * Метод определяет, приобретать ли поле, на которую попал игрок, или же выставить на аукцион
     * @param field поле, на которое попал игрок
     * @return {@code true}, если принято решение приобрести поле
     */
    public abstract boolean takeProperty(ClassicField field);

    /**
     * Метод определяет, какую сумму поставить на аукционе в свой ход
     * @param field поле, которое разыгрывается на аукционе
     * @param sum   текущая сумма аттракциона
     * @return Конечное значение денег, не меньшее текущей налички, если игрок решил продолжать участие в аукционе,
     *         null, если игрок отказался от участия в аукционе
     */
    public abstract Integer auction(ClassicField field, int sum);

    /**
     * Метод вызывается, когда у игрока кончается наличка. Конкретные реализации чё-то там делают внутри, и в итоге
     * счёт игрока должен стать неотрицательным
     * @return {@code true}, если игроку удалось выйти в "плюс", {@code false}, если не удалось
     */
    public abstract boolean winMoney();

    /**
     * Метод вызывается, когда игроку предложена торговля. Игрок рассматривает предложение и определяет, принимать его
     * или отвергать
     * @param tradeProposition торговое предложение
     * @return {@code true}, если игрок согласился на данное предложение
     */
    public abstract boolean acceptTrade(TradeProposition tradeProposition);

    /**
     * Метод вызывается в конце хода игрока и является предложением что-нибудь сделать напоследок, например, построить
     * дома, отели, поторговать с кем-нибудь или самовыпилиться
     */
    public abstract void doAnyActions();

    /**
     * Метод устанавливает переменную-ссылку на параметры текущей игры
     * @param game объект "игра"
     */
    public void setGame(Game game) {
        this.game = game;
    }

    public void setSelf(int number) {
        self = number;
    }
}
