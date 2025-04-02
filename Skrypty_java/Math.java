Math.max() // wyciąga tylko z dwóch argumentów

// z tablicy arrays.stream
int[] table = {first, second, third};
System.out.println("Max z tablicy to "+Arrays.stream(table).max().getAsInt());
System.out.println("Min z tablicy to "+Arrays.stream(table).min().getAsInt());

// ilość iteracji w pętli for, np dla średniej arytmetycznej
        for (int i=1; i<=x; i=i+2) {
            sumaNieparz=sumaNieparz+i;
        }
        iteracje = ((x-1)/2)+1;
        gdzie (x-1) to -> i=x to max wartość, i=1 to min wartość
