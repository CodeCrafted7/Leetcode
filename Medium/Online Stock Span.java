class StockSpanner {
    List<Integer> prices;
    public StockSpanner() {
        prices = new ArrayList<>();
    }
    public int next(int price) {
        if (prices.size() == 0) {
                prices.add(price);
                return 1;
        } else {
                prices.add(price);
                int count = 0;
                for (int i = prices.size() - 1; i >= 0; i--) {
                    if (price >= prices.get(i)) count++;
                    else break;
                }
                return count;
        }
    }
}
