import sys

if __name__ == "__main__":
    print(sys.argv)
    with open('C:\\Users\\RHoza\\Documents\\csfdapp\\output.txt', 'a') as f:
        for arg in sys.argv:
            f.write(arg)
            f.write(", ")
        f.write("\n")

    input("Press Enter to continue...")
