package logic;

import logic.enums.ClassicField;

import java.util.HashSet;
import java.util.Set;

/**
 *  ласс, предназначенный дл€ хранени€ торгового предложени€ от одного игрока другому
 * Created by user1 on 19.10.2015.
 */
public class TradeProposition {

    /**
     * Ќомер игрока, предложившего сделку
     */
    private int proposer;
    /**
     * Ќомер игрока, которому предлагаетс€ сделка
     */
    private int recipient;
    /**
     * —умма перевода, котора€ предлагаетс€ при сделке (от предлагател€ к получателю). ћожет быть отрицательной.
     */
    private int givenMoney;
    /**
     * —писок предложенных собственностей
     */
    private Set<ClassicField> proposedFields;
    /**
     * —писок собственностей, запрашиваемых взамен
     */
    private Set<ClassicField> requestedFields;

    public TradeProposition() {
        proposedFields = new HashSet<>();
        requestedFields = new HashSet<>();
    }

    public boolean proposeProperty(ClassicField field)
    {
        if (!proposedFields.contains(field))
        {
            if (!requestedFields.contains(field)) {
                proposedFields.add(field);
                return true;
            }

        }
        return false;
    }

    public boolean requestProperty(ClassicField field)
    {
        if (!requestedFields.contains(field))
        {
            if (!proposedFields.contains(field)) {
                requestedFields.add(field);
                return true;
            }
        }
        return false;
    }

    public int getProposer() {
        return proposer;
    }

    public int getRecipient() {
        return recipient;
    }

    public int getGivenMoney() {
        return givenMoney;
    }

    public Set<ClassicField> getProposedProperty() {
        return proposedFields;
    }

    public Set<ClassicField> getRequestedProperty() {
        return requestedFields;
    }

    public void setProposer(int proposer) {
        this.proposer = proposer;
    }

    public void setRecipient(int recipient) {
        this.recipient = recipient;
    }

    public void setGivenMoney(int money) {
        givenMoney = money;
    }
}
