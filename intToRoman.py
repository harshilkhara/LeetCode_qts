'''
Approach- Greedy algorithm 

'''

def intToRoman(num):           # TC O(1) // SC O(1)
    digits = [(1000, "M"), (900, "CM"), (500, "D"), (400, "CD"), (100, "C"), 
              (90, "XC"), (50, "L"), (40, "XL"), (10, "X"), (9, "IX"), 
              (5, "V"), (4, "IV"), (1, "I")]

    roman_digits = []
    # Loop through each symbol.
    for value, symbol in digits:
        # We don't want to continue looping if we're done.
        if num == 0: break
        count, num = divmod(num, value)
        # Append "count" copies of "symbol" to roman_digits.
        roman_digits.append(symbol * count)
    return "".join(roman_digits)


def intToRoman1(num):
    thousands = ["", "M", "MM", "MMM"]
    hundreds = ["", "C", "CC", "CCC", "CD", "D", "DC", "DCC", "DCCC", "CM"]
    tens = ["", "X", "XX", "XXX", "XL", "L", "LX", "LXX", "LXXX", "XC"]
    ones = ["", "I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX"]
    return (thousands[num // 1000] + hundreds[num % 1000 // 100] 
           + tens[num % 100 // 10] + ones[num % 10])


print(intToRoman(58))
print(intToRoman1(588))

