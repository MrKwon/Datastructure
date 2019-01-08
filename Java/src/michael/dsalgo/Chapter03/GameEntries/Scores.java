package michael.dsalgo.Chapter03.GameEntries;

public class Scores {
    public static final int maxEntries = 10;
    protected int numEntries;
    protected GameEntry[] entries; // Object Composition

    public Scores() {
        entries = new GameEntry[maxEntries];
        numEntries = 0;
    }

    @Override
    public String toString() {
        String s = "[";
        for (int i = 0; i < numEntries; i++) {
            if (i > 0) s += ", ";
            s += entries[i];
        }
        return s + "]";
    }


    /**
     * add(GameEntry entry) method
     * GameEntry entry 를 추가한다
     * 만약 entries[]가 가득 차있다면, entries[]에 있는 가장 작은 원소와 추가하려는 원소를 비교한다.
     * entires[].lowest < entry.score 일 경우 entries[].lowest를 제거하고 entry.score 를 추가
     * entries[].lowest > entry.score 일 경우 아무것도 수행하지 않는다.
     * 추가하는 경우 적절한 위치에 삽입하고 그 이후 원소들을 하나씩 미룬다.
     */
    public void add(GameEntry entry) {
        int newScore = entry.getScore(); // entry의 score

        if (numEntries == maxEntries) { // entries 가 가득 차있는 경우
            if (newScore <= entries[numEntries - 1].getScore()) // newScore 가 entries 의 가장 작은 score 보다 작거나 같으면
                return; // 아무것도 안함
        }
        else // 가득 차있지 않으면 그냥 추가함
            numEntries++;

        // 가득 차있지 않은 경우와, newScore 가 entries 의 가장 작은 score 보다 크면
        int i = numEntries - 1; // i는 맨 마지막 원소의 index
        for ( ; (i >= 1) && (newScore > entries[i - 1].getScore()); i--)
            // i가 0이 될 때까지, newScore가 i - 1번째 score보다 클 때까지 반복
            entries[i] = entries[i - 1]; // 한칸씩 뒤로 밀기
        entries[i] = entry; // 적절한 위치에 entry를 끼워 넣는다.
    }

    /**
     * remove(GameEntry entry) method
     * GameEntry entry 를 제거하고 그 index i를 반환한다.
     * index i 가 entries array의 범위를 벗어나면 exception을 throw 한다.
     * 그리고 나서 index i 에 있는 object를 제거하고 한칸씩 앞으로 땡겨서 채운다.
     */
    public GameEntry remove(int i) throws IndexOutOfBoundsException {
        if ((i < 0) || (i >= numEntries)) // i가 valid index 가 아닐 경우 exception 을 throwing
            throw new IndexOutOfBoundsException("Invalid Index : " + i);

        GameEntry tmp = entries[i]; // 제거할 entries[i] 를 tmp 객체에 저장

        for (int j = i; j < numEntries - 1; j++) // 제거해야 되는 원소의 위치부터 뒤에 있는 원소를 한칸씩 땡김
            entries[j] = entries[j + 1];

        entries[numEntries - 1] = null; // 마지막 원소는 제거
        numEntries--; // 현재 entries 에 들어있는 원소 수를 하나 줄임
        return tmp;
    }
}
