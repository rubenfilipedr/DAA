/*
Dado um fragmento de ADN alienígena, a tua tarefa é produzir uma listagem das
letras que aparecem em pelo menos uma vez, ordenada por ordem decrescente da sua
frequência (número de occorrências) e em caso de empate pela ordem em que aparecem
primeiro no fragmento (ou seja, tendo em conta a primeira ocorrência de cada letra).
*/

import java.util.*;
import java.io.*;


class Letter implements Comparable<Letter> {
  public char ch;            // letra em si
  public int freq;          // frequência
  public int firstOccur;    // posição da 1ª ocorrência (começa em 0)

  Letter() {
    ch = '0';
    freq = 0;
    firstOccur = -1;
  }

  Letter(char ch, int firstOccur) {
    this.ch = ch;
    freq = 0;
    this.firstOccur = firstOccur;
  }

  public int compareTo(Letter l) {
    if (freq < l.freq) return 1;
    if (freq > l.freq) return -1;
    if (firstOccur < l.firstOccur) return -1;
    if (firstOccur > l.firstOccur) return 1;
    return 0;
  }

}


class daa009 {

  public static void main (String[] args) {
    FastScanner in = new FastScanner(System.in);

    Letter v[] = new Letter[26];
    char c = 'A';
    for (int i=0 ; i<26 ; i++) {
      v[i] = new Letter(c, -1);
      c++;
    }

    String t = in.next();
    int tLength = t.length();
    for (int i=0 ; i<tLength ; i++) {
      v[t.charAt(i)-'A'].freq++;
      if (v[t.charAt(i)-'A'].firstOccur == -1) v[t.charAt(i)-'A'].firstOccur = i;
    }

    Arrays.sort(v);
    for (int i=0 ; i<26 ; i++) {
      if (v[i].freq > 0) FastPrint.out.println(v[i].ch + " " + v[i].freq);
    }

    FastPrint.out.close();

  }

}
