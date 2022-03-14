package Froggy;

import java.util.Iterator;

public class Lake implements Iterable<Integer> {
    int[] numbers;

    public Lake(int[] numbers) {
        this.numbers = numbers;
    }

    public class Frog implements Iterator<Integer> {
        private int index = 0;
        private boolean isOdd = false;

        @Override
        public boolean hasNext() {
            if (this.index >= numbers.length && !isOdd) {
                isOdd = true;
                this.index = 1;
            }

            return this.index < numbers.length;
        }

        @Override
        public Integer next() {
            int currentIndex = this.index;
            this.index += 2;

            return numbers[currentIndex];
        }
    }

    @Override
    public Iterator<Integer> iterator() {
        return new Frog();
    }
}
