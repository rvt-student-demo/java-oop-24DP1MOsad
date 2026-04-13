package rvt;
import java.util.Map;
import java.util.HashMap;

public class IOU {
    Map<String, Double> iou;

    public IOU() {
        this.iou = new HashMap<>();
    }

    public void setSum(String toWhom, double amount) {
        iou.put(toWhom, amount);
    }

    public double howMuchDoIOweTo(String toWhom) {
        if (iou.containsKey(toWhom)) {
            return iou.get(toWhom);
        } else {
            return 0.0;
        }
    }
}
