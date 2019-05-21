public class TER {
    public static void main(String[] args) {
        ModelTop[] modelTop = ModelTop.values();
        //排名统计总数量和当天数量,传递固件型号不确定
        for (ModelTop top : modelTop) {
            System.out.print(top.getCountArray()[0]);
            System.out.print(top.getCountArray()[1]);
            System.out.print(top.getCountArray()[2]);
        }
    }
    private static final Integer[] defaultInit={0,0,0};
    public enum ModelTop{

        newTop("New Hubs",defaultInit),totalTop("TotalHubs",defaultInit);

        private  String modeName;
        private Integer[] countArray;

        private ModelTop(String modeName, Integer[] countArray) {
            this.modeName = modeName;
            this.countArray=countArray;
        }

        public String getModeName() {
            return modeName;
        }

        public Integer[] getCountArray() {
            return countArray;
        }

        public void setCountArray(Integer[] countArray) {
            this.countArray = countArray;
        }
    }
}
