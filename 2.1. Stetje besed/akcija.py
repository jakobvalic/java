import sys
 
 
def akcija(zaloga, poraba, dan, mesec):
    datumi = {"januar": 1, "februar": 2, "marec": 3, "april": 4,
              "maj": 5, "junij": 6, "julij": 7, "avgust": 8,
              "september": 9, "oktober": 10, "november": 11,
              "december": 12}
    dnevi = [0, 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31]
    indeks_mesec = datumi[mesec]
    if indeks_mesec < 4:
        return "V SMETI"
    elif indeks_mesec == 4:
        if dan < 20:
            return "V SMETI"
        elif dan >= 20:
            razlika = dan - 19
    else:
        razlika = 11
        for i in range(5, indeks_mesec):
            razlika += dnevi[i]
        razlika += dan
    if zaloga > float("{:2f}".format(razlika * poraba)):
        return "AKCIJA"
    return "OK"
 
input()
for vrstica in sys.stdin:
    zaloga, poraba, dan, mesec, leto = vrstica.strip().split(" ")
    print(akcija(int(zaloga), float(poraba), int(dan[:-1]), mesec))
