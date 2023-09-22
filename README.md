# Theory Quiz 3

This quiz contains two problems. Here is a runtime analysis in $O(n)$ for each.

## MiniMax Sum

My solution to this problem runs in $O(n)$, since it contains one loop and no functions that
run in greater than $O(1)$:

$$
\begin{gather}
\sum_{i=0}^{n} 1 \\
n
\end{gather}
$$

## Hackerrank In A String

My solution to this problem runs in $O(n)$. This is easily analyzed by transforming the 
recursive call tree into a simple series of calls, which can be done trivially because the recursion 
does not run over the input string, but rather over a static array:

```java
public static boolean subsequenceHasHackerrankRec(String s, int i /* = 0*/, int previousIndexChecked) {
        if (i >= HACKERRANK_CHARS.length) return true;

        char c = HACKERRANK_CHARS[i];
        int nextCharacterIndex = s.indexOf(c, previousIndexChecked + 1);
        if (nextCharacterIndex == -1) return false;


        //subsequenceHasHackerrankRec(s, 1, nextCharacterIndex);
        {
            if (i >= HACKERRANK_CHARS.length) return true;

            char c = HACKERRANK_CHARS[i];
            int nextCharacterIndex = s.indexOf(c, previousIndexChecked + 1);
            if (nextCharacterIndex == -1) return false;

            //subsequenceHasHackerrankRec(s, 2, nextCharacterIndex);
            {
                ...
            }
        }
    }
```

(note: this is not valid Java; it's just intended to show how the code in `HackerrankInAStringSolution.java` can be flattened trivially because of the static array that it 'loops' over)

$$
\sum_{i=0}^{ |"hackerrank"| } \text{indexof(c, x)}
$$

Since `indexof` runs in $O(n)$, this is equivalent to 

$$
\begin{gather}
\sum_{i=0}^{10} \sum_{i=0}^{n} 1 \\
\sum_{i=0}^{10}n
\end{gather}
$$

which is asymtotically 
equivalent to $O(n)$ (because initial coefficients aren't in big O notation).

