package logic.enums;

/**
 * Класс, описывающий возможные типы полей игрового поля
 * Created by user1 on 18.10.2015.
 */
public enum FieldType {
    /**
     * Коммунальные услуги (2 шт.)
     */
    utility,
    /**
     * Железные дороги (4 шт.)
     */
    railroad,
    /**
     * Карты собственности (22 шт.)
     */
    property,
    /**
     * Шанс (3 шт.)
     */
    chance,
    /**
     * Сундук (2 шт.)
     */
    communityChest,
    /**
     * Карты, при попадании на которые нужно немедленно что-то сделать:
     * 1) Income Tax,
     * 2) Go To Jail,
     * 3)Luxury Tax
     */
    action,
    /**
     * Прочие карты:
     * 1) Go
     * 2) Just visiting jail
     * 3) Free Parking
     */
    other
}
