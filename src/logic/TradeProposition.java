package logic;

import logic.enums.ClassicField;

import java.util.HashSet;
import java.util.Set;

/**
 * �����, ��������������� ��� �������� ��������� ����������� �� ������ ������ �������
 * Created by user1 on 19.10.2015.
 */
public class TradeProposition {

    /**
     * ����� ������, ������������� ������
     */
    private int proposer;
    /**
     * ����� ������, �������� ������������ ������
     */
    private int recipient;
    /**
     * ����� ��������, ������� ������������ ��� ������ (�� ������������ � ����������). ����� ���� �������������.
     */
    private int givenMoney;
    /**
     * ������ ������������ ��������������
     */
    private Set<ClassicField> proposedFields;
    /**
     * ������ ��������������, ������������� ������
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
