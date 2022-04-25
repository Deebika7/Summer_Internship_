import java.util.HashMap;

public class Reward {
    static HashMap<Integer,Integer> reward=new HashMap<>();

    public static void reward(int cardNumber, int billAmount) {
        int rewardPoint=billAmount/100;

            if (reward.get(cardNumber)!=null) {
                int currentPoint = reward.get(cardNumber);
                reward.put(cardNumber, rewardPoint + currentPoint);
            } else {
                reward.put(cardNumber, rewardPoint);
            }
            int rewardValue = reward.get(cardNumber);
            if (rewardValue>=10) {
                GiftCard.GiftCards.get(cardNumber).GiftCardBalance += ((rewardValue/10)*10);
                reward.replace(cardNumber, rewardValue%10);
            }
    }
}
