package logic;

/**
 * Created by user1 on 18.10.2015.
 */
public class ClassicTable {


    private int place[];
    private int railroadNumber[];
    private int utilityNumber[];
    private boolean chanceOutOfJail[];
    private boolean chestOutOfJail[];

    private int owner[];
    private CardType type[];
    private boolean mortgaged[];
    private String propertyName[];
    private boolean boughtable[];
    private int price[];
    private int rent1[];
    private int rent2[];
    private int rent3[];
    private int rentAll[];
    private int rent1House[];
    private int rent2House[];
    private int rent3House[];
    private int rent4House[];
    private int rentHotel[];
    private int mortgageValue[];
    private int HousePrice[];
    private int colorGroup[];
    private int stageDevelopment[];

    private String chanceCardName[], chestCardName[];
    private int nChanceCards, nChestCards;
    private int chanceCards[], chestCards[];
    private int curChanceCard, curChestCard;

    private int monopolyHolder[];

    private Random rand;
    private boolean noFurtherTurnsFlag=false;
    private int curPlayer;
    private boolean end=false;
    private int dice,dice1,dice2;
    private boolean duble, injail, tojail;
    private boolean flagNoSalary=false, flagRepeat=false, flagDoubleRailroadRent=false,
            flagUtilityTen=false;

    private boolean flagNoInformation=true, flagNoBlab=flagNoInformation, flagPrintProperties=false;
    private boolean flagNoMonopolyInformation=false;

    //переменные для режима 0:
    private boolean flagOutOfJailDesire=false;
    private long nPass[], nStop[], nTurn, nZarplata, nIncome, nTax, nJail, nOutOfJailByCard;
    private long chanceMoney=0, chestMoney=0, jailMoney=0;
    private float pPass[], pStop[];
    private long nMaxTurn=2000000000;						/////////////////////////////////////////
    private long nRound=0;
    private long CGN[][], railroadN[], utilityN[], jailN[];
    private int curRailroadN, curUtilityN, curCGN[], curJailN;

    //переменные для режимов>0:
    private float jailRentOutOfJail, chanceRentOutOfJail, chestRentOutOfJail, goRentOutOfJail, incomeRentOutOfJail, luxRentOutOfJail;
    private float jailRentJail, chanceRentJail, chestRentJail, goRentJail, incomeRentJail, luxRentJail;
    private float pPassOutOfJail[], pPassJail[];
    private int beginner, numberOfTurns, prevPlayer;

    private String s1;
    private Scanner sc;

    //переменные для режима 1:
    private int nGames=10000;
    private int monopolyRandomSucсess[];
    private int groupNumber[];
    private int nRandomMonopolies;

    //переменные для режима 2:
    private int nMaxGameTurns=200000000;
    private int rank[], curLowestRank;
    private String description;
    private int chatlan[];
    private float meanRentOutOfJail[], meanRentJail[];

    public Mezhdumordie(int number_players, int rej)
    {
        rand = new Random();
        regime=rej;
        numberOfPlayers=number_players;
        playerName=new String[numberOfPlayers];
        cash=new int[numberOfPlayers];
        defeated=new boolean[numberOfPlayers];
        place=new int[numberOfPlayers];
        playerInterface=new AutomaticPlayer[numberOfPlayers];
        railroadNumber=new int[numberOfPlayers];
        utilityNumber=new int[numberOfPlayers];
        chanceOutOfJail=new boolean[numberOfPlayers];
        chestOutOfJail=new boolean[numberOfPlayers];
        rank=new int[numberOfPlayers];
        chatlan=new int[numberOfPlayers];
        utilityN=new long[20];
        railroadN=new long[20];
        jailN=new long[20];
        CGN=new long[9][20];
        curCGN=new int[9];
        if(regime==1) playerInterface=new AutomaticPlayer[numberOfPlayers];
        for(int i=0;i<numberOfPlayers;i++)
        {
            //System.out.println(i);
            char symbol=(char)(65+i);
            playerName[i]=""+symbol;
            if(regime>=1) playerInterface[i]=new AutomaticPlayer(this, i);
            //if(regime==2) playerInterface[i]=new AutomaticPlayer(this, i);
            //playerInterface=new HumanPlayer();
        }
        monopolyHolder=new int[9];
        if(regime==1)
        {
            monopolyRandomSucсess=new int[9];
            groupNumber=new int[9];
            for(int i=0;i<=8;i++)
            {
                monopolyRandomSucсess[i]=0;
                groupNumber[i]=0;
            }
        }

        initializeBoard();

        if(regime==0)
        {
            nPass=new long[42];
            nStop=new long[42];
            pPass=new float[42];
            pStop=new float[42];
            nTurn=0;
            nZarplata=0;
            nTax=0;
            nIncome=0;
            nJail=0;
            nOutOfJailByCard=0;
            for(int i=0; i<9;i++)
                for(int j=0;j<20;j++)
                    CGN[i][j]=0;
            for(int j=0;j<20;j++)
            {
                railroadN[j]=0;
                utilityN[j]=0;
                jailN[j]=0;
            }
            curRailroadN=0;
            curUtilityN=0;
            curJailN=0;
            for(int i=0;i<9;i++)
                curCGN[i]=0;
        }

        if(regime>=1)
        {
            pPassOutOfJail=new float[41];
            pPassJail=new float[41];
            sc = new Scanner(System.in);
            String line = null;
            //String str = null;		Не понадобилось
            //int index=0;
            //int amount=0;
            int i = 0;
            //int N = 0; // Число строк в файле
            float nextDatum;
            StringTokenizer token;
            try
            {
                FileReader fr1 = new FileReader("C:\\games\\Monopoly_files\\probabilities_fast.txt");
                BufferedReader in1 = new BufferedReader(fr1);
                //System.out.println("Тюрьмофоб-стайл.");
                while( (line = in1.readLine()) != null)
                {
                    //System.out.println(line);
                    token = new StringTokenizer(line);
                    while(token.hasMoreElements())
                    {
                        nextDatum=Float.parseFloat(token.nextElement().toString());
                        if(i==0)
                        {
                            goRentOutOfJail=nextDatum;
                            //System.out.println("Среднее количество бабла от GO/ход: "+nextDatum);
                        }
                        if(i==1)
                        {
                            chestRentOutOfJail=nextDatum;
                            //System.out.println("Среднее количество бабла из ящика/ход: "+nextDatum);
                        }
                        if(i==2)
                        {
                            incomeRentOutOfJail=nextDatum;
                            //System.out.println("Среднее количество бабла от income tax/ход: "+nextDatum);
                        }
                        if(i==3)
                        {
                            chanceRentOutOfJail=nextDatum;
                            //System.out.println("Среднее количество бабла от chance/ход: "+nextDatum);
                        }
                        if(i==4)
                        {
                            jailRentOutOfJail=nextDatum;
                            //System.out.println("Среднее количество бабла от тюрьмы/ход: "+nextDatum);
                        }
                        if(i==5)
                        {
                            luxRentOutOfJail=nextDatum;
                            //System.out.println("Среднее количество бабла от luxury tax/ход: "+nextDatum);
                        }
                        if(i>=6 && i<=45)
                        {
                            pPassOutOfJail[i-6]=nextDatum;
                            //System.out.println(propertyName[i-6]+" имеет вероятность "+pPassOutOfJail[i-6]);
                        }
                        if(i==46)
                        {
                            pPassOutOfJail[i-6]=nextDatum;
                            //System.out.print("Нахождение в тюрьме имеет вероятность "+pPassOutOfJail[i-6]);
                        }
                        i++;
                    }
                }
                //N = i;
                //System.out.print("Number of lines in the text file = ");
                //System.out.println(N);
                in1.close();
            }
            catch(Exception ex)
            {
                System.out.println("Cannot read form the 1 text file");
            }

            i=0;
            try (BufferedReader in1 = new BufferedReader(new FileReader("C:\\games\\Monopoly_files\\probabilities_slow.txt")))
            {
                //System.out.println("Тюрьмолюб-стайл.");
                while( (line = in1.readLine()) != null)
                {
                    //System.out.println(line);
                    token = new StringTokenizer(line);
                    while(token.hasMoreElements())
                    {
                        nextDatum=Float.parseFloat(token.nextElement().toString());
                        if(i==0)
                        {
                            goRentJail=nextDatum;
                            //System.out.println("Среднее количество бабла от GO/ход: "+nextDatum);
                        }
                        if(i==1)
                        {
                            chestRentJail=nextDatum;
                            //System.out.println("Среднее количество бабла из ящика/ход: "+nextDatum);
                        }
                        if(i==2)
                        {
                            incomeRentJail=nextDatum;
                            //System.out.println("Среднее количество бабла от income tax/ход: "+nextDatum);
                        }
                        if(i==3)
                        {
                            chanceRentJail=nextDatum;
                            //System.out.println("Среднее количество бабла от chance/ход: "+nextDatum);
                        }
                        if(i==4)
                        {
                            jailRentJail=nextDatum;
                            //System.out.println("Среднее количество бабла от тюрьмы/ход: "+nextDatum);
                        }
                        if(i==5)
                        {
                            luxRentJail=nextDatum;
                            //System.out.println("Среднее количество бабла от luxury tax/ход: "+nextDatum);
                        }
                        if(i>=6 && i<=45)
                        {
                            pPassJail[i-6]=nextDatum;
                            //System.out.println(propertyName[i-6]+" имеет вероятность "+pPassJail[i-6]);
                        }
                        if(i==46)
                        {
                            pPassJail[i-6]=nextDatum;
                            //System.out.println("Нахождение в тюрьме имеет вероятность "+pPassJail[i-6]);
                        }
                        i++;
                    }
                }
                //N = i;
                //System.out.print("Number of lines in the text file = ");
                //System.out.println(N);
                in1.close();
            }
            catch(Exception ex)
            {
                System.out.println("Cannot read form the 2 text file");
            }
        }
    }

    private void initializeBoard()
    {
        owner=new int[40];
        boughtable=new boolean[40];
        mortgaged=new boolean[40];
        propertyName=new String[40];
        type=new CardType[40];
        price=new int[40];
        rent1=new int[40];
        rent2=new int[40];
        rent3=new int[40];
        rentAll=new int[40];
        rent1House=new int[40];
        rent2House=new int[40];
        rent3House=new int[40];
        rent4House=new int[40];
        rentHotel=new int[40];
        mortgageValue=new int[40];
        HousePrice=new int[40];
        colorGroup=new int[40];
        stageDevelopment=new int[40];
        nChanceCards=15;
        nChestCards=16;
        chanceCards=new int[nChanceCards];
        chestCards=new int[nChestCards];
        chanceCardName=new String[nChanceCards];
        chestCardName=new String[nChestCards];
        meanRentOutOfJail=new float[40];
        meanRentJail=new float[40];

        for(int i=0;i<=39;i++)
        {
            owner[i]=-1;
            mortgaged[i]=false;
            stageDevelopment[i]=0;
            switch(i)
            {

            }
        }
        for(int i=0;i<16;i++)
        {
            if(i<15) chanceCards[i]=i;
            chestCards[i]=i;
            switch(i)
            {
                case 0:
                    chanceCardName[i]="Advance to GO";
                    chestCardName[i]="Advance to GO";
                    break;
                case 1:
                    chanceCardName[i]="Your building and loan matures";
                    chestCardName[i]="Receive for services";
                    break;
                case 2:
                    chanceCardName[i]="Make the general repairs";
                    chestCardName[i]="Income tax refund";
                    break;
                case 3:
                    chanceCardName[i]="Go to the nearest railroad";
                    chestCardName[i]="Pay doctor's fee";
                    break;
                case 4:
                    chanceCardName[i]="Go to the nearest utility";
                    chestCardName[i]="Pay school tax";
                    break;
                case 5:
                    chanceCardName[i]="Go to St.Charles place";
                    chestCardName[i]="Second prize for beauty";
                    break;
                case 6:
                    chanceCardName[i]="Card out of jail";
                    chestCardName[i]="Insurance";
                    break;
                case 7:
                    chanceCardName[i]="Elected chairman of the board";
                    chestCardName[i]="Pay hospital";
                    break;
                case 8:
                    chanceCardName[i]="Go to Illinois avenue";
                    chestCardName[i]="You inherit";
                    break;
                case 9:
                    chanceCardName[i]="Go to the Reading railroad";
                    chestCardName[i]="Bank error in your favor";
                    break;
                case 10:
                    chanceCardName[i]="Poor tax";
                    chestCardName[i]="Grand opera night";
                    break;
                case 11:
                    chanceCardName[i]="Go to Boardwalk";
                    chestCardName[i]="Street repairs";
                    break;
                case 12:
                    chanceCardName[i]="Bank pays you dividends";
                    chestCardName[i]="Xmas fund matures";
                    break;
                case 13:
                    chanceCardName[i]="Go 3 spaces back";
                    chestCardName[i]="From sale of stock";
                    break;
                case 14:
                    chanceCardName[i]="Go to jail";
                    chestCardName[i]="Get out of jail free";
                    break;
                case 15:
                    chestCardName[i]="Go to jail";
                    break;
            }
        }
    }

    public void start()
    {
        if(regime!=1) nGames=1;
        for(int numberGame=0;numberGame<nGames;numberGame++)
        {
            if(regime==1) if(numberGame%(nGames/100)==0) System.out.println("Game "+numberGame+"...");
            end=false;				//начальная инициализация переменных
            noFurtherTurnsFlag=false;
            flagNoSalary=false;
            flagRepeat=false;
            flagDoubleRailroadRent=false;
            flagUtilityTen=false;

            for(int i=0; i<numberOfPlayers;i++)
            {
                defeated[i]=false;
                cash[i]=1500;             /////////////////////////////////////////////////
                defeated[i]=false;
                place[i]=0;
                railroadNumber[i]=0;
                utilityNumber[i]=0;
                chanceOutOfJail[i]=false;
                chestOutOfJail[i]=false;
                rank[i]=0;
            }
            for(int i=1;i<=8;i++)
                monopolyHolder[i]=-1;

            for(int i=0;i<=39;i++)
            {
                owner[i]=-1;
                mortgaged[i]=false;
                stageDevelopment[i]=0;
                meanRentOutOfJail[i]=0;
                meanRentJail[i]=0;
            }
            shuffleChanceChest();

            if(regime!=0) curPlayer=rand.nextInt(numberOfPlayers); else curPlayer=0;
            beginner=curPlayer;
            numberOfTurns=0;
            curLowestRank=4;

            while(!end)
            {
                if(regime==0)
                {
                    nTurn++;
                    if(!flagNoInformation) System.out.println("Ход №"+nTurn+".");
                }
                if(!flagNoInformation && regime!=0) System.out.print("\nХодит "+playerName[curPlayer]+"; позиция - "+place[curPlayer]+"; деньги - "+cash[curPlayer]+".");
                tojail=false;
                if(place[curPlayer]>=41 && place[curPlayer]<=43) injail=true; else injail=false;
                if(injail)
                {
                    //спрашиваем игрока, согласен ли выйти, по карте или за деньги, если да, то injail=false; если нет,
                    //то ролляем. Если дубль, то выходит из тюрьмы (injail всё ещё false) и
                    //oneTurn; если нет, то передвигаем на +1 или платим штраф и oneTurn.
                    if(regime==0)					//пробный режим
                    {
                        if(flagOutOfJailDesire)     //ранний выход из тюрьмы
                        {
                            if(chanceOutOfJail[curPlayer])
                            {
                                chanceOutOfJail[curPlayer]=false;
                                if(!flagNoInformation) System.out.println("Вышел из тюрьмы по карте Chance!");
                                place[curPlayer]=10;
                                injail=false;
                                nOutOfJailByCard++;
                            }
                            else
                            {
                                if(chestOutOfJail[curPlayer])
                                {
                                    chestOutOfJail[curPlayer]=false;
                                    if(!flagNoInformation) System.out.println("Вышел из тюрьмы по карте Community Chest!");
                                    place[curPlayer]=10;
                                    injail=false;
                                    nOutOfJailByCard++;
                                }
                                else
                                {
                                    place[curPlayer]=10;
                                    injail=false;
                                    takeMoney(curPlayer, 50);
                                    jailMoney-=50;
                                }
                            }
                        }
                        else						//поздний выход из тюрьмы
                        {
                            if(place[curPlayer]<=42) //первые два броска
                            {
                                diceThrow();
                                if(duble)
                                {
                                    if(!flagNoInformation) System.out.println("Дубль, и вы выходите на свободу!");
                                    place[curPlayer]=10;
                                    performTurn();
                                }
                                else
                                {
                                    if(!flagNoInformation) System.out.println("Нет дубля.");
                                    nPass[41]++;
                                    place[curPlayer]++;
                                }
                            }
                            else					//последний бросок или выход по карте
                            {
                                if(chanceOutOfJail[curPlayer])
                                {
                                    chanceOutOfJail[curPlayer]=false;
                                    if(!flagNoInformation) System.out.println("Вышел из тюрьмы по карте Chance!");
                                    place[curPlayer]=10;
                                    injail=false;
                                    nOutOfJailByCard++;
                                }
                                else
                                {
                                    if(chestOutOfJail[curPlayer])
                                    {
                                        chestOutOfJail[curPlayer]=false;
                                        if(!flagNoInformation) System.out.println("Вышел из тюрьмы по карте Community Chest!");
                                        place[curPlayer]=10;
                                        injail=false;
                                        nOutOfJailByCard++;
                                    }
                                    else
                                    {
                                        diceThrow();
                                        if(duble)
                                        {
                                            if(!flagNoInformation) System.out.println("Дубль, и вы выходите на свободу!");
                                            place[curPlayer]=10;
                                            performTurn();
                                        }
                                        else
                                        {
                                            if(!flagNoInformation) System.out.print("Вас выпроваживают из тюрьмы пинком под зад. ");
                                            place[curPlayer]=10;
                                            takeMoney(curPlayer, 50);
                                            jailMoney-=50;
                                            performTurn();
                                        }
                                    }
                                }
                            }
                        }
                    }
                    else					//режимы, кроме 0
                    {
                        JailDecision stayInJail;
                        stayInJail=playerInterface[curPlayer].stayInJail();
                        switch(stayInJail)
                        {
                            case stay:
                                diceThrow();
                                if(duble)
                                {
                                    if(!flagNoInformation) System.out.println("Дубль, и вы выходите на свободу!");
                                    place[curPlayer]=10;
                                    performTurn();
                                }
                                else
                                {
                                    if(!flagNoInformation) System.out.println("Нет дубля.");
                                    if(place[curPlayer]<43)
                                    {
                                        if(regime==0) nPass[41]++;
                                        place[curPlayer]++;
                                    }
                                    else
                                    {
                                        if(!flagNoInformation) System.out.print("Вас выпроваживают из тюрьмы пинком под зад. ");
                                        place[curPlayer]=10;
                                        takeMoney(curPlayer, 50);
                                        findDebtors();
                                        performTurn();
                                        findDebtors();
                                    }
                                }
                                break;
                            case pay:
                                place[curPlayer]=10;
                                injail=false;
                                takeMoney(curPlayer, 50);
                                findDebtors();
                                break;
                            case card:
                                if(chanceOutOfJail[curPlayer])
                                    chanceOutOfJail[curPlayer]=false;
                                else
                                if(chestOutOfJail[curPlayer])
                                    chestOutOfJail[curPlayer]=false;
                                else
                                {
                                    System.out.println("Что за херня с выходом из тюрьмы?!");
                                    break;
                                }
                                place[curPlayer]=10;
                                injail=false;
                                break;
                        }
                    }
                }
                if(!injail)
                {
                    doTurn();
                    findDebtors();
                    if(duble && !noFurtherTurnsFlag)
                    {
                        if(!flagNoInformation) System.out.println("Дубль! Ходите снова.");
                        doTurn();
                        findDebtors();
                        if(duble && !noFurtherTurnsFlag)
                        {
                            if(!flagNoInformation) System.out.println("Второй дубль подряд! Ходите снова.");
                            diceThrow();
                            if(duble && !noFurtherTurnsFlag)
                            {
                                if(!flagNoInformation) System.out.println("Три дубля подряд! В тюрьму!");
                                tojail=true;
                            }
                            if(!duble && !noFurtherTurnsFlag)
                            {
                                performTurn();
                                findDebtors();
                            }
                        }
                    }
                }
                if(tojail==true)
                {
                    if(regime==0)
                    {
                        nJail++;
                        nPass[41]++;
                        curJailN++;
                    }
                    place[curPlayer]=41;
                }

                if(noFurtherTurnsFlag) noFurtherTurnsFlag=false;			//действия по завершению хода
                if(regime!=0) playerInterface[curPlayer].doAnyActions();
                if(regime!=0) testEnd();
                prevPlayer=curPlayer;
                if(regime!=0) curPlayer=nextPlayer(curPlayer);
                if(prevPlayer<beginner && beginner<=curPlayer
                        || curPlayer<prevPlayer && prevPlayer<beginner
                        || beginner<=curPlayer && curPlayer<prevPlayer)
                {
                    numberOfTurns++;
                    if(!flagNoInformation) System.out.println("Законичились ходы №"+numberOfTurns+".");
                }
                if(regime==0)
                {
                    if(place[curPlayer]<=40) nStop[place[curPlayer]]++; else nStop[41]++;
                    if(!flagNoInformation && regime==0) System.out.println("Совершено "+nTurn+" ходов.");
                    if(flagNoInformation && nTurn%(nMaxTurn/100)==0) System.out.println(nTurn);
                    if(nTurn>=nMaxTurn)
                    {
                        end=true;
                    }
                }

                if(regime==1)
                {
                    testRasprodazha();
                }
                if(regime==2)
                {
                    if(numberOfTurns>nMaxGameTurns)
                    {
                        int allChatlan=0;
                        for(int i=0;i<numberOfPlayers;i++)
                        {
                            if(!defeated[i])
                            {
                                chatlan[i]=costOfProperties(i);
                                allChatlan+=chatlan[i];
                            }
                            else chatlan[i]=-1;
                        }
                        //System.out.println("Суммарное бабло в игре - "+allChatlan+".");
                        end=true;
                        for(; curLowestRank>0; curLowestRank--)
                        {
                            int curLowestSum=allChatlan;
                            int curRankPretendant=-1;
                            for(int i=0;i<numberOfPlayers;i++)
                            {
                                if(rank[i]==0 && chatlan[i]<curLowestSum)
                                {
                                    curRankPretendant=i;
                                    curLowestSum=chatlan[i];
                                }
                            }
                            if(curRankPretendant>=0) rank[curRankPretendant]=curLowestRank;
                        }
                    }
                }
            }
            if(!flagNoInformation && regime==1) System.out.println("Игра №"+(numberGame+1)+" закончена на "+numberOfTurns+" ходу.");

            if(regime==0)
            {
                System.out.println("Количество ходов - "+nTurn+";");
                for(int i=0;i<40;i++)
                {
                    pStop[i]=1.0f*nStop[i]/nTurn;
                    pPass[i]=1.0f*nPass[i]/nTurn;
                    System.out.println(i+", "+propertyName[i]+" - "+pStop[i]*100+"%; "+ pPass[i]*100+"%.");
                }
                pStop[41]=1.0f*nStop[41]/nTurn;
                pPass[41]=1.0f*nPass[41]/nTurn;
                System.out.println("41, In jail - "+pStop[41]*100+"%; "+ pPass[41]*100+"%.");
                System.out.println("Денег от Go за ход - "+200f*nZarplata/nTurn+".");
                System.out.println("Минус денег от Income Tax за ход - "+200f*nIncome/nTurn+".");
                System.out.println("Минус денег от Luxury Tax за ход - "+75f*nTax/nTurn+".");
                System.out.println("Вероятность попасть в тюрьму - "+1.0f*nJail/nTurn+".");
                System.out.println("Среднее бабло от Chance за ход - "+1f*chanceMoney/nTurn+".");
                System.out.println("Среднее бабло от Community Chest за ход - "+1f*chestMoney/nTurn+".");
                System.out.println("Среднее бабло от тюрьмы за ход - "+1f*jailMoney/nTurn+".");
                System.out.println("Доля выходов из тюрьмы по карте - "+1f*nOutOfJailByCard/nJail+".");
                System.out.println("Бабло от тюрьмы: "+jailMoney);
                System.out.println("Бабло от шанса: "+chanceMoney);
                System.out.println("Бабло от ящика: "+chestMoney);
                for(int i=0;i<40;i++)
                    System.out.print(pStop[i]+"\t");
                System.out.println(pStop[41]);
                for(int i=0;i<40;i++)
                    System.out.print(pPass[i]+"\t");
                System.out.println(pPass[41]);

                System.out.println("*********************************");
                System.out.println("Количество раундов: "+nRound+", средняя продолжительность раунда: "+1f*nMaxTurn/nRound);
                for(int i=1; i<=8; i++)
                {
                    System.out.println("\n"+i+" цветовая группа: ");
                    for(int j=0; j<20;j++)
                    {
                        if(CGN[i][j]>0) System.out.print(j+" - "+CGN[i][j]+"; "+1f*CGN[i][j]/nRound);
                        else continue;
                        if(j>0) System.out.println(";  k = "+1f*CGN[i][j-1]/CGN[i][j]); else System.out.println();
                    }
                }
                System.out.println("\nUtilities: ");
                for(int j=0; j<20;j++)
                {
                    if(utilityN[j]>0) System.out.print(j+" - "+utilityN[j]+"; "+1f*utilityN[j]/nRound);
                    else continue;
                    if(j>0) System.out.println(";  k = "+1f*utilityN[j-1]/utilityN[j]); else System.out.println();
                }
                System.out.println("\nRailroads: ");
                for(int j=0; j<20;j++)
                {
                    if(railroadN[j]>0) System.out.print(j+" - "+railroadN[j]+"; "+1f*railroadN[j]/nRound);
                    else continue;
                    if(j>0) System.out.println(";  k = "+1f*railroadN[j-1]/railroadN[j]); else System.out.println();
                }
                System.out.println("\nJail: ");
                for(int j=0; j<20;j++)
                {
                    if(jailN[j]>0) System.out.print(j+" - "+jailN[j]+"; "+1f*jailN[j]/nRound);
                    else continue;
                    if(j>0) System.out.println(";  k = "+1f*jailN[j-1]/jailN[j]); else System.out.println();
                }
            }
            if(regime==1)
            {
                if(flagPrintProperties)
                {
                    for(int i=0;i<numberOfPlayers;i++)
                    {
                        System.out.print(playerName[i]+": ");
                        for(int j=0;j<40;j++)
                        {
                            if(owner[j]==i) System.out.print(j+", ");
                        }
                        System.out.println(cash[i]+"$.");
                    }
                }
                nRandomMonopolies=0;
                for(int i=1;i<=8;i++)
                {
                    if(monopolyHolder[i]!=-1)
                    {
                        if(flagPrintProperties) System.out.println("Собрана монополия на "+i+" цветовой группе.");
                        monopolyRandomSucсess[i]++;
                        nRandomMonopolies++;
                    }
                }
                groupNumber[nRandomMonopolies]++;
            }
            if(regime==2)
            {
                for(int i=0;i<numberOfPlayers;i++)
                {
                    if(defeated[i]) description="Обанкротился.";
                    else description="Дожил до конца, сумма - "+costOfProperties(i)+".";
                    System.out.println(playerName[i]+" занял "+rank[i]+" место. "+description);
                }
            }
        }
        if(regime==1)
        {
            float r=1;
            for(int i=1; i<=8; i++)
            {
                int pogr=(int) Math.sqrt(monopolyRandomSucсess[i]);
                float prob=1f*monopolyRandomSucсess[i]/nGames;
                float probPogr=prob*pogr/monopolyRandomSucсess[i];
                r*=(1-prob);
                System.out.println(i+" - "+monopolyRandomSucсess[i]+" ± "+pogr+"; "+prob+" ± "+probPogr);
            }
            System.out.println("Probability of random failure: "+r);
            for(int i=1;i<=8;i++)
            {
                System.out.println("Probability of "+i+" random monopolies: "+groupNumber[i]);
            }
        }
    }

    public void testEnd()
    {
        int ndefeated=0;
        int plNotDefeated=-1;
        for(int j=0;j<numberOfPlayers;j++)
            if(defeated[j]) ndefeated++;
            else plNotDefeated=j;
        if(ndefeated==numberOfPlayers-1)
        {
            if(regime>=2) rank[plNotDefeated]=1;
            System.out.println(playerName[plNotDefeated]+" выиграл!!!");
            end=true;
        }
    }

    public void doTurn()
    {
        diceThrow();
        performTurn();
    }

    public void performTurn()
    {
        move(place[curPlayer]+dice);
        doActions();
    }

    public void diceThrow()
    {
        if(!flagNoInformation && regime>=1) s1=sc.nextLine();
        dice1=rand.nextInt(6)+1;
        dice2=rand.nextInt(6)+1;
        if(dice1==dice2) duble=true; else duble=false;
        dice=dice1+dice2;
        if(!flagNoInformation) System.out.println(dice1+" + "+dice2+" = "+dice+"; duble = "+duble);
    }

    public void giveMoney(int pl, int sum)
    {
        cash[pl]+=sum;
        if(!flagNoInformation) System.out.println(playerName[pl]+" дали "+sum+" денег.");
    }

    public void takeMoney(int pl, int sum)
    {
        cash[pl]-=sum;
        if(!flagNoInformation) System.out.println("У "+playerName[pl]+" отобрали "+sum+" денег.");
    }

    public void transferMoney(int giver, int receiver, int sum)
    {
        cash[giver]-=sum;
        cash[receiver]+=sum;
        if(!flagNoInformation) System.out.println(playerName[giver]+" передал "+playerName[receiver]+" "+sum+" денег.");
    }

    public void zarplata(int pl)
    {
        if(flagNoSalary) return;
        if(regime==0) nZarplata++;
        cash[pl]+=200;
        if(!flagNoInformation) System.out.println(playerName[pl]+" получил свою зарплату - 200 денег.");
        if(regime==0)
        {
            railroadN[curRailroadN]++;
            utilityN[curUtilityN]++;
            jailN[curJailN]++;
            for(int j=1;j<=8;j++)
            {
                CGN[j][curCGN[j]]++;
            }
            curRailroadN=0;
            curUtilityN=0;
            curJailN=0;
            for(int i=0;i<9;i++)
                curCGN[i]=0;
            nRound++;
        }
    }

    public int nextPlayer(int prevPlayer)
    {
        int playa;
        if(prevPlayer<numberOfPlayers-1) playa=prevPlayer+1; else playa=0;
        if(defeated[playa]) playa=nextPlayer(playa);
        return playa;
    }

    public int costOfProperties(int pl)
    {
        int sum=cash[pl];
        for(int i=1;i<40;i++)
        {
            if(owner[i]==pl) sum+=price[i];
        }
        return sum;
    }

    public void move(int where)
    {
        if(where<place[curPlayer]) zarplata(curPlayer);
        place[curPlayer]=where;
        if (place[curPlayer]>39)
        {
            place[curPlayer]=place[curPlayer]%40;
            zarplata(curPlayer);
        }
    }

    public void doActions()
    {
        int card=place[curPlayer];
        if(!flagNoInformation) System.out.println(card+", "+propertyName[card]);
        if(regime==0)
        {
            nPass[card]++;
        }
        //обработка действий по приземлению на карточку:
        if(type[card]==CardType.chance)
        {
            int numberCard=chanceCards[curChanceCard];
            if(!flagNoInformation) System.out.println(chanceCardName[numberCard]);
            switch(numberCard)
            {
                case 0:
                    move(0);
                    flagRepeat=true;
                    break;
                case 1:
                    giveMoney(curPlayer, 150);
                    if(regime==0) chanceMoney+=150;
                    break;
                case 2:
                    int sum=0;
                    for(int i=0;i<40;i++)
                    {
                        if(owner[i]==curPlayer && type[i]==CardType.property)
                        {
                            switch(stageDevelopment[i])
                            {
                                case 0:
                                    break;
                                case 1:
                                    sum+=25;
                                    break;
                                case 2:
                                    sum+=25*2;
                                    break;
                                case 3:
                                    sum+=25*3;
                                    break;
                                case 4:
                                    sum+=25*4;
                                    break;
                                case 5:
                                    sum+=100;
                                    break;
                            }
                        }
                    }
                    if(sum>0)
                    {
                        takeMoney(curPlayer,sum);
                        if(regime==0) chanceMoney-=sum;
                    }
                    break;
                case 3:
                    flagRepeat=true;
                    if(place[curPlayer]==7) move(15);
                    else
                    if(place[curPlayer]==22) move(25);
                    else
                    if(place[curPlayer]==36) move(5);
                    else
                    {
                        System.out.println("WTF?! Chance nearest railroad not found!");
                    }
                    flagRepeat=true;
                    flagDoubleRailroadRent=true;
                    break;
                case 4:
                    flagRepeat=true;
                    flagUtilityTen=true;
                    if(place[curPlayer]==7 || place[curPlayer]==36) move(12);
                    else
                    if(place[curPlayer]==22) move(28);
                    else
                    {
                        System.out.println("WTF?! Chance nearest utility not found!");
                    }
                    break;
                case 5:
                    move(11); //St.Charles
                    flagRepeat=true;
                    break;
                case 6:
                    chanceOutOfJail[curPlayer]=true;
                    break;
                case 7:
                    if(regime==0) chanceMoney-=150;
                    for(int i=0;i<numberOfPlayers;i++)
                        if(i!=curPlayer && !defeated[i]) transferMoney(curPlayer, i, 50);
                    break;
                case 8:
                    move(24); //Illinois
                    flagRepeat=true;
                    break;
                case 9:
                    move(5); // Reading railroad
                    flagRepeat=true;
                    break;
                case 10:
                    takeMoney(curPlayer, 15);
                    if(regime==0) chanceMoney-=15;
                    break;
                case 11:
                    move(39); //Boardwalk
                    flagRepeat=true;
                    break;
                case 12:
                    giveMoney(curPlayer, 50);
                    if(regime==0) chanceMoney+=50;
                    break;
                case 13:
                    flagNoSalary=true;
                    move(place[curPlayer]-3);
                    flagNoSalary=false;
                    flagRepeat=true;
                    break;
                case 14:
                    tojail=true;
                    if(!flagNoInformation) System.out.println(playerName[curPlayer]+" попал в тюрьму.");
                    noFurtherTurnsFlag=true;
                    break;
            }
            curChanceCard++;
            if(curChanceCard>=nChanceCards) curChanceCard=0;
        }

        if(type[card]==CardType.chest)
        {
            int numberCard=chestCards[curChestCard];
            if(!flagNoInformation) System.out.println(chestCardName[numberCard]);
            switch(numberCard)
            {
                case 0:
                    move(0);
                    flagRepeat=true;
                    break;
                case 1:
                    giveMoney(curPlayer, 25);
                    if(regime==0) chestMoney+=25;
                    break;
                case 2:
                    giveMoney(curPlayer, 20);
                    if(regime==0) chestMoney+=20;
                    break;
                case 3:
                    takeMoney(curPlayer, 50);
                    if(regime==0) chestMoney-=50;
                    break;
                case 4:
                    takeMoney(curPlayer, 150);
                    if(regime==0) chestMoney-=150;
                    break;
                case 5:
                    giveMoney(curPlayer, 10);
                    if(regime==0) chestMoney+=10;
                    break;
                case 6:
                    giveMoney(curPlayer, 100);
                    if(regime==0) chestMoney+=100;
                    break;
                case 7:
                    takeMoney(curPlayer, 100);
                    if(regime==0) chestMoney-=100;
                    break;
                case 8:
                    giveMoney(curPlayer, 100);
                    if(regime==0) chestMoney+=100;
                    break;
                case 9:
                    giveMoney(curPlayer, 200);
                    if(regime==0) chestMoney+=200;
                    break;
                case 10:
                    if(regime==0) chestMoney+=150;
                    for(int i=0;i<numberOfPlayers;i++)
                    {
                        if(i!=curPlayer && !defeated[i]) transferMoney(i, curPlayer, 50);
                    }
                case 11:
                    int sum=0;
                    for(int i=0;i<40;i++)
                    {
                        if(owner[i]==curPlayer && type[i]==CardType.property)
                        {
                            switch(stageDevelopment[i])
                            {
                                case 0:
                                    break;
                                case 1:
                                    sum+=40;
                                    break;
                                case 2:
                                    sum+=40*2;
                                    break;
                                case 3:
                                    sum+=40*3;
                                    break;
                                case 4:
                                    sum+=40*4;
                                    break;
                                case 5:
                                    sum+=115;
                                    break;
                            }
                        }
                    }
                    if(sum>0)
                    {
                        takeMoney(curPlayer,sum);
                        if(regime==0) chestMoney-=sum;
                    }
                    break;
                case 12:
                    giveMoney(curPlayer, 100);
                    if(regime==0) chestMoney+=100;
                    break;
                case 13:
                    giveMoney(curPlayer, 45);
                    if(regime==0) chestMoney+=45;
                    break;
                case 14:
                    chestOutOfJail[curPlayer]=true;
                    break;
                case 15:
                    tojail=true;
                    if(!flagNoInformation) System.out.println(playerName[curPlayer]+" попал в тюрьму.");
                    noFurtherTurnsFlag=true;
                    break;
            }
            curChestCard++;
            if(curChestCard>=nChestCards) curChestCard=0;
        }

        if(card==4)
        {
            if(regime==0)
            {
                takeMoney(curPlayer, 200);
                nIncome++;
            }
            else
            {
                boolean if200=playerInterface[curPlayer].IncomeTax200();
                if(if200) takeMoney(curPlayer, 200);
                else takeMoney(curPlayer, costOfProperties(curPlayer)/10);
            }
        }
        if(card==38)
        {
            if(regime==0) nTax++;
            if(!flagNoInformation && regime==0) System.out.println("Вы попали на бабло.");
            takeMoney(curPlayer, 75);
        }
        if(card==30)
        {
            if(!flagNoInformation) System.out.println("Вы попали в тюрьму.");
            tojail=true;
            noFurtherTurnsFlag=true;
        }
        if(card==20)
        {
            if(!flagNoInformation && regime==0) System.out.println("Вы попали на бесплатную стоянку.");
        }
        if(card==0)
        {
            if(!flagNoInformation && regime==0) System.out.println("Вы приземлились на ВПЕРЁД.");
        }
        if(card==10)
        {
            if(!flagNoInformation && regime==0) System.out.println("Вы видите зеков, смотрящих на вас из-за решётки.");
        }
        if(boughtable[card])
        {
            if(regime!=0)
            {
                if(owner[card]==-1)
                {
                    boolean takeProperty=playerInterface[curPlayer].takeProperty(card);
                    if(takeProperty && cash[curPlayer]>=price[card])
                    {
                        acquireProperty(curPlayer,card,price[card]);
                    }
                    else auction(card);
                }
                else
                if(owner[card]!=curPlayer)
                {
                    int master=owner[card];
                    boolean mortgaga=false;
                    if(mortgaged[card])
                    {
                        mortgaga=true;
                        if(!flagNoInformation) System.out.println(propertyName[card]+" заложена "+playerName[master]+".");
                    }
                    if(type[card]==CardType.utility && !mortgaga)
                    {
                        if(!flagUtilityTen)
                            if(utilityNumber[master]==2)
                            {
                                transferMoney(curPlayer, master, 10*dice);
                            }
                            else
                            {
                                transferMoney(curPlayer, master, 4*dice);
                            }
                        else
                        {
                            flagUtilityTen=false;
                            diceThrow();
                            transferMoney(curPlayer, master, 10*dice);
                        }
                    }
                    if(type[card]==CardType.railroad && !mortgaga)
                    {
                        int sum;
                        if(railroadNumber[master]>2)
                            if(railroadNumber[master]==3) { sum=rent3[card]; }
                            else { sum=rentAll[card]; }
                        else
                        if(railroadNumber[master]==1) { sum=rent1[card]; }
                        else { sum=rent2[card]; }
                        if(flagDoubleRailroadRent)
                        {
                            flagDoubleRailroadRent=false;
                            sum*=2;
                        }
                        transferMoney(curPlayer,master,sum);
                    }
                    if(type[card]==CardType.property && !mortgaga)
                    {
                        if(monopolyHolder[colorGroup[card]]==master)
                        {
                            switch(stageDevelopment[card])
                            {
                                case 0:
                                    transferMoney(curPlayer,master,rentAll[card]);
                                    break;
                                case 1:
                                    transferMoney(curPlayer,master,rent1House[card]);
                                    break;
                                case 2:
                                    transferMoney(curPlayer,master,rent2House[card]);
                                    break;
                                case 3:
                                    transferMoney(curPlayer,master,rent3House[card]);
                                    break;
                                case 4:
                                    transferMoney(curPlayer,master,rent4House[card]);
                                    break;
                                case 5:
                                    transferMoney(curPlayer,master,rentHotel[card]);
                                    break;
                            }
                        }
                        else
                        {
                            transferMoney(curPlayer,master,rent1[card]);
                        }
                    }
                }
            }
            else
            {
                if(regime==0)
                {
                    if(type[card]==CardType.property)
                        curCGN[colorGroup[card]]++;
                    else
                    if(type[card]==CardType.railroad)
                        curRailroadN++;
                    else
                    if(type[card]==CardType.utility)
                        curUtilityN++;
                }
            }
        }

        //some actions

        if(flagRepeat)
        {
            flagRepeat=false;
            doActions();
        }
    }

    public void updateMonopolyVariables(int card)
    {
        int owningPlayer=owner[card];
        if(type[card]==CardType.property)
        {
            int group=colorGroup[card];
            boolean colorFlag=false;
            //boolean colorFlag[]=new boolean[9];
            //for(int i=0;i<9;i++)
            //	colorFlag[i]=false;
            switch(group)
            {
                case 1:
                    if(owningPlayer==owner[1] && owningPlayer==owner[3] && monopolyHolder[group]!=owningPlayer) colorFlag/*[1]*/=true;
                    break;
                case 2:
                    if(owningPlayer==owner[6] && owningPlayer==owner[8] && owningPlayer==owner[9] && monopolyHolder[group]!=owningPlayer) colorFlag/*[2]*/=true;
                    break;
                case 3:
                    if(owningPlayer==owner[11] && owningPlayer==owner[13] && owningPlayer==owner[14] && monopolyHolder[group]!=owningPlayer) colorFlag/*[3]*/=true;
                    break;
                case 4:
                    if(owningPlayer==owner[16] && owningPlayer==owner[18] && owningPlayer==owner[19] && monopolyHolder[group]!=owningPlayer) colorFlag/*[4]*/=true;
                    break;
                case 5:
                    if(owningPlayer==owner[21] && owningPlayer==owner[23] && owningPlayer==owner[24] && monopolyHolder[group]!=owningPlayer) colorFlag/*[5]*/=true;
                    break;
                case 6:
                    if(owningPlayer==owner[26] && owningPlayer==owner[27] && owningPlayer==owner[29] && monopolyHolder[group]!=owningPlayer) colorFlag/*[6]*/=true;
                    break;
                case 7:
                    if(owningPlayer==owner[31] && owningPlayer==owner[32] && owningPlayer==owner[34] && monopolyHolder[group]!=owningPlayer) colorFlag/*[7]*/=true;
                    break;
                case 8:
                    if(owningPlayer==owner[37] && owningPlayer==owner[39] && monopolyHolder[group]!=owningPlayer) colorFlag/*[8]*/=true;
                    break;
            }
            //for(int j=1;j<=8;j++)
            //{
            if(colorFlag)
            {
                monopolyHolder[group]=owningPlayer;
                playerInterface[owningPlayer].addMonopoly(group);
                if(!flagNoMonopolyInformation)
                {
                    System.out.println(playerName[owningPlayer]+" собрал монополию по "+group+" цветовой группе!");
                    switch(group)
                    {
                        case 1:
                            updateMeanRent(1);
                            updateMeanRent(3);
                            break;
                        case 2:
                            updateMeanRent(6);
                            updateMeanRent(8);
                            updateMeanRent(9);
                            break;
                        case 3:
                            updateMeanRent(11);
                            updateMeanRent(13);
                            updateMeanRent(14);
                            break;
                        case 4:
                            updateMeanRent(16);
                            updateMeanRent(18);
                            updateMeanRent(19);
                            break;
                        case 5:
                            updateMeanRent(21);
                            updateMeanRent(23);
                            updateMeanRent(24);
                            break;
                        case 6:
                            updateMeanRent(26);
                            updateMeanRent(27);
                            updateMeanRent(29);
                            break;
                        case 7:
                            updateMeanRent(31);
                            updateMeanRent(32);
                            updateMeanRent(34);
                            break;
                        case 8:
                            updateMeanRent(37);
                            updateMeanRent(39);
                            break;
                    }
                }
            }
            //}
        }
        if(type[card]==CardType.utility)
        {
            for(int i=0;i<numberOfPlayers;i++)
                utilityNumber[i]=0;
            if(owner[12]>=0) utilityNumber[owner[12]]++;
            if(owner[28]>=0) utilityNumber[owner[28]]++;
        }
        if(type[card]==CardType.railroad)
        {
            for(int i=0;i<numberOfPlayers;i++)
                railroadNumber[i]=0;
            if(owner[5]>=0) railroadNumber[owner[5]]++;
            if(owner[15]>=0) railroadNumber[owner[15]]++;
            if(owner[25]>=0) railroadNumber[owner[25]]++;
            if(owner[35]>=0) railroadNumber[owner[35]]++;
        }
    }

    public void auction (int property)
    {
        if(!flagNoInformation) System.out.println("Начинается аукцион на "+propertyName[property]+".");
        int pl=curPlayer;
        while(defeated[pl])
        {
            if(pl<numberOfPlayers-1) pl=pl+1; else pl=0;
        }
        boolean flag;
        int highestPrice=0, nPlInAuc=0, result, highestBetter=-1;
        boolean inAuction[]=new boolean[numberOfPlayers];
        for(int i=0;i<numberOfPlayers;i++)
            if(!defeated[i])
            {
                inAuction[i]=true;
                nPlInAuc++;
            }
            else inAuction[i]=false;
        while(nPlInAuc>1)
        {
            flag=true;
            result=playerInterface[pl].auction(property, highestPrice);
            //System.out.println(playerName[pl]+" предложил цену "+result+".");
            if(result<=highestPrice || result>cash[pl])
            {
                inAuction[pl]=false;
                nPlInAuc--;
                if(!flagNoInformation) System.out.println(playerName[pl]+" отвалился из аукциона.");
            }
            else
            {
                highestPrice=result;
                highestBetter=pl;
            }
            while(flag)
            {
                if(pl<numberOfPlayers-1) pl=pl+1; else pl=0;
                if(!defeated[pl] && inAuction[pl]) flag=false;
            }
        }
        if(highestPrice==0)
        {
            for(int i=0;i<numberOfPlayers;i++)
                if(inAuction[i]) highestBetter=i;
            if(cash[highestBetter]>0) highestPrice=1;
            else
            {
                if(!flagNoInformation) System.out.println("Никто не смог приобрести"+propertyName[property]+", так что оно остаётся ничейным.");
                owner[property]=-1;
                updateMonopolyVariables(property);
                updateMeanRent(property);
                return;
            }
        }
        acquireProperty(highestBetter, property, highestPrice);
    }

    public void acquireProperty(int pl, int card, int moneye)
    {
        takeMoney(pl, moneye);
        owner[card]=pl;
        if(!flagNoInformation) System.out.println(propertyName[card]+" теперь принадлежит "+playerName[pl]+".");
        updateMonopolyVariables(card);
        updateMeanRent(card);
    }

    public void mortgage(int card, boolean mortgaga)
    {
        if(!boughtable[card])
        {
            System.out.println("Что за хрень? Как я могу заложить непродающееся?!");
            return;
        }
        if(owner[card]==-1)
        {
            System.out.println("Что за хрень? Как я могу заложить ничейное имущество?!");
            return;
        }
        mortgaged[card]=mortgaga;
        giveMoney(owner[card],price[card]/2);
    }

    public String getPropertyName(int y) { return propertyName[y]; }

    public int getPrice(int prop) { return price[prop]; }

    public int getCash(int pl) { return cash[pl]; }

    public boolean getFlagNoInformation() { return flagNoInformation; }

    public boolean getFlagNoBlab() { return flagNoBlab; }

    public float getIncome(int pl, boolean outOfJail)
    {
        float sum;
        if(outOfJail)
        {
            sum=jailRentOutOfJail+chanceRentOutOfJail+chestRentOutOfJail+goRentOutOfJail+incomeRentOutOfJail+luxRentOutOfJail;
            for(int i=1;i<40;i++)
            {
                if(owner[i]==-1 || owner[i]==pl || mortgaged[i]) continue;
                sum+=meanRentOutOfJail[i];
            }
        }
        else
        {
            sum=jailRentJail+chanceRentJail+chestRentJail+goRentJail+incomeRentJail+luxRentJail;
            for(int i=1;i<40;i++)
            {
                if(owner[i]==-1 || owner[i]==pl || mortgaged[i]) continue;
                sum+=meanRentJail[i];
            }
        }
        return sum;
    }

    public int getPlace(int pl) { return place[pl]; }

    public boolean getCard(int pl) { return(chanceOutOfJail[pl] || chestOutOfJail[pl]); }

    public boolean getMortgaged(int card) { return mortgaged[card]; }

    public int getOwner(int card) { return owner[card]; }

    public String getPlayerName(int pl) { return playerName[pl]; }

    public void findDebtors()
    {
        for(int i=0;i<numberOfPlayers;i++)
        {
            if(defeated[i]) continue;
            if(!flagNoInformation) System.out.println("У игрока "+playerName[i]+" "+cash[i]+" денег.");
            if(cash[i]>=0) continue;
            if(regime==0) break;

            boolean result=playerInterface[i].winMoney();
            if(!result)
            {
                defeated[i]=true;
                noFurtherTurnsFlag=true;
                if(regime>=2) rank[i]=curLowestRank;
                curLowestRank--;
                //if(i==curPlayer && owner[place[i]]!=curPlayer)
                int killer=owner[place[i]];
                if(killer==-1)
                {
                    for(int j=1;j<40;j++)
                    {
                        if(owner[j]==i)
                        {
                            owner[j]=-1;
                            mortgaged[j]=false;
                            auction(j);
                        }
                    }
                }
                else
                {
                    for(int j=1;j<40;j++)
                    {
                        if(owner[j]==i)
                        {
                            owner[j]=killer;
                            mortgaged[j]=false;  //обдумать, может, стоит оставлять их замортгаженными?..
                            updateMeanRent(j);
                        }
                    }
                }
                testEnd();
            }
        }
    }

    public void testRasprodazha()
    {
        for(int i=0;i<40;i++)
        {
            if(boughtable[i] && owner[i]==-1) return;
        }
        end=true;
    }

    public void shuffleChanceChest()
    {
        int nextCard, slot;
        for(int i=nChanceCards;i>1;i--)
        {
            nextCard=rand.nextInt(i);
            slot=chanceCards[i-1];
            chanceCards[i-1]=chanceCards[nextCard];
            chanceCards[nextCard]=slot;
        }
        for(int i=nChestCards;i>1;i--)
        {
            nextCard=rand.nextInt(i);
            slot=chestCards[i-1];
            chestCards[i-1]=chestCards[nextCard];
            chestCards[nextCard]=slot;
        }
        if(!flagNoInformation && regime==0)
        {
            System.out.println("Community Chest Cards:");

            for(int i=0;i<16;i++)
            {
                System.out.print(chestCards[i]+", ");
            }
            System.out.println("\nChance Cards:");
            for(int i=0;i<15;i++)
            {
                System.out.print(chanceCards[i]+", ");
            }
            System.out.println();
        }
        curChanceCard=nChanceCards-1;
        curChestCard=nChestCards-1;
    }

    public void updateMeanRent(int card)
    {
        if(!boughtable[card])
        {
            System.out.println("WTF!? Mean rent update mistake! >_<");
            return;
        }
        if(owner[card]==-1)
        {
            meanRentJail[card]=0;
            meanRentOutOfJail[card]=0;
            return;
        }
        switch(type[card])
        {
            case utility:
                if(utilityNumber[owner[card]]==1)
                {
                    meanRentOutOfJail[card]=4*7*pPassOutOfJail[card];
                    meanRentJail[card]=4*7*pPassJail[card];
                }
                if(utilityNumber[owner[card]]==2)
                {
                    meanRentOutOfJail[card]=10*7*pPassOutOfJail[card];
                    meanRentJail[card]=10*7*pPassJail[card];
                }
                break;
            case railroad:
                switch(railroadNumber[owner[card]])
                {
                    case 1:
                        meanRentOutOfJail[card]=rent1[card]*pPassOutOfJail[card];
                        meanRentJail[card]=rent1[card]*pPassJail[card];
                        break;
                    case 2:
                        meanRentOutOfJail[card]=rent2[card]*pPassOutOfJail[card];
                        meanRentJail[card]=rent2[card]*pPassJail[card];
                        break;
                    case 3:
                        meanRentOutOfJail[card]=rent3[card]*pPassOutOfJail[card];
                        meanRentJail[card]=rent3[card]*pPassJail[card];
                        break;
                    case 4:
                        meanRentOutOfJail[card]=rentAll[card]*pPassOutOfJail[card];
                        meanRentJail[card]=rentAll[card]*pPassJail[card];
                        break;
                }
                break;
            case property:
                if(monopolyHolder[colorGroup[card]]!=owner[card])
                {
                    meanRentOutOfJail[card]=rent1[card]*pPassOutOfJail[card];
                    meanRentJail[card]=rent1[card]*pPassJail[card];
                    return;
                }
                switch(stageDevelopment[card])
                {
                    case 0:
                        meanRentOutOfJail[card]=rentAll[card]*pPassOutOfJail[card];
                        meanRentJail[card]=rentAll[card]*pPassJail[card];
                        break;
                    case 1:
                        meanRentOutOfJail[card]=rent1House[card]*pPassOutOfJail[card];
                        meanRentJail[card]=rent1House[card]*pPassJail[card];
                        break;
                    case 2:
                        meanRentOutOfJail[card]=rent2House[card]*pPassOutOfJail[card];
                        meanRentJail[card]=rent2House[card]*pPassJail[card];
                        break;
                    case 3:
                        meanRentOutOfJail[card]=rent3House[card]*pPassOutOfJail[card];
                        meanRentJail[card]=rent3House[card]*pPassJail[card];
                        break;
                    case 4:
                        meanRentOutOfJail[card]=rent4House[card]*pPassOutOfJail[card];
                        meanRentJail[card]=rent4House[card]*pPassJail[card];
                        break;
                    case 5:
                        meanRentOutOfJail[card]=rentHotel[card]*pPassOutOfJail[card];
                        meanRentJail[card]=rentHotel[card]*pPassJail[card];
                        break;
                }
                break;
            default:
                System.out.println("WTF!? Mean rent update mistake! >_<");
                return;
        }
    }

    public float getMeanRentOutOfJail(int pl) { return meanRentOutOfJail[pl]; }

    public int getStageDevelopment(int card) { return stageDevelopment[card]; }

    public boolean knockDownHouse(int card)
    {
        if(stageDevelopment[card]<=0)
        {
            System.out.println("Ошибка! Нет домов, нечего сносить.");
        }
        stageDevelopment[card]--;
        if(stageDevelopment[card]==0)
        {
            boolean noMoreHouses=true;
            int color=colorGroup[card];
            switch(color)
            {
                case 1:
                    if(stageDevelopment[1]>0 || stageDevelopment[3]>0) noMoreHouses=false;
                    break;
                case 2:
                    if(stageDevelopment[6]>0 || stageDevelopment[8]>0 || stageDevelopment[9]>0) noMoreHouses=false;
                    break;
                case 3:
                    if(stageDevelopment[11]>0 || stageDevelopment[13]>0 || stageDevelopment[14]>0) noMoreHouses=false;
                    break;
                case 4:
                    if(stageDevelopment[16]>0 || stageDevelopment[18]>0 || stageDevelopment[19]>0) noMoreHouses=false;
                    break;
                case 5:
                    if(stageDevelopment[21]>0 || stageDevelopment[23]>0 || stageDevelopment[24]>0) noMoreHouses=false;
                    break;
                case 6:
                    if(stageDevelopment[26]>0 || stageDevelopment[27]>0 || stageDevelopment[29]>0) noMoreHouses=false;
                    break;
                case 7:
                    if(stageDevelopment[31]>0 || stageDevelopment[32]>0 || stageDevelopment[34]>0) noMoreHouses=false;
                    break;
                case 8:
                    if(stageDevelopment[37]>0 || stageDevelopment[39]>0) noMoreHouses=false;
                    break;
            }
            if(noMoreHouses) playerInterface[owner[card]].noMoreHouses(color);
        }
        return true;
    }
}
