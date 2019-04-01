import time
import support
ticks = time.asctime(time.localtime(time.time()))
print(ticks)
str = "hello word!"
print(str)
support.print_func("luokp")
for i in range(0,1000000000000000000000):
    try:
        print(i)
        if i > 100000 :
            raise Exception("jiushinia ")
    except :
        for c in "luokp":
            print(c,'\n')
        break

class Employee:
    '所有员工的基类'
    count = 0

    def __init__(self, name, salary):
        self.name = name
        self.salary = salary
        Employee.count += 1

    def displayCount(self):
        print(Employee.count)

    def disEmployee(self):
        print("name: ", self.name, '\n', "Salary: ", self.salary)

em = Employee('luokp', 40000)
em.disEmployee()
em.displayCount()
print(Employee.__bases__)
print(Employee.__dict__)

del em

