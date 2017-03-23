import matplotlib.pyplot as plt

f = open("map.txt")


mapfile = []
lines = []
for line in f.readlines():
    mapfile.append(line)
f.close()

for line in mapfile:
    for i in mapfile:
        a = i.strip().split("^")
        b = a[0].replace("[","").replace("]","").split(", ")
        c = a[1].replace("[","").replace("]","").split(", ")
        d = [[int(b[0]),int(c[0])], [int(b[1]),int(c[1])]]
        lines.append(d)

plt.figure()
for i in range(len(lines)):
    #print(lines[i])
    plt.plot(lines[i][0],lines[i][1])

plt.show()
