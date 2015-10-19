package players;

import action.Game;
import logic.Rules.Rules;
import logic.TradeProposition;
import logic.enums.ClassicField;
import logic.enums.JailDecision;

/**
 * Класс определяет поведение самого что ни на есть бесхитростного бота. Он никогда не торгуется, все торговые
 * предложения отвергает, все собственности покупает, кроме случая, когда у него нет денег - тогда он выставляет их
 * на аукцион. Умеет строить дома и отели и сносить их, когда требуется бабло. По сути, он может выиграть, только если
 * ему по чистой случайности удастся попасть на монополию.
 * Created by user1 on 19.10.2015.
 */
public class PrimitiveComputerPlayer extends PlayerStrategy {

    private Rules rules;

    @Override
    public String getName() {
        return null;
    }

    @Override
    public JailDecision stayInJail() {
        return game.hasJailCard(self) ? JailDecision.card : JailDecision.stay;
    }

    @Override
    public boolean chooseIncomeTaxFix() {
        return game.getCash(self) > rules.getIncomeTaxFixed() * (100.0 / rules.getIncomeTaxProportional());
    }

    @Override
    public boolean takeProperty(ClassicField field) {
        if (game.getCash(self) > field.getPrice()) {
            mortgageSomePossessions(field.getPrice() - game.getCash(self));
        }
        return game.getCash(self) > field.getPrice();
    }

    @Override
    public Integer auction(ClassicField field, int sum) {
        if (field.getPrice() > sum && game.getCash(self) > sum) {
            return Math.min(sum + (int) (field.getPrice() * Math.random() * 0.1) + 1, game.getCash(self));
        } else {
            return null;
        }
    }

    @Override
    public boolean winMoney() {
        mortgageSomePossessions(-game.getCash(self));
        if (game.getCash(self) < 0) {
            sellSomeHouses();
        }
        return game.getCash(self) >= 0;
    }

    @Override
    public boolean acceptTrade(TradeProposition tradeProposition) {
        return false;
    }

    @Override
    public void doAnyActions() {
        if (canBuildHouses()) {
            buildSomeHouses();
        }
        if (!canBuildHouses() && canUnmortgage()) {
            unmortgageSomePossessions();
        }
    }

    @Override
    public void setGame(Game game) {
        this.game = game;
        rules = game.getRules();
    }
}
