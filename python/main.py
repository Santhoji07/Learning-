#print("hello") #printing statement

#name="santhoji" #declaring variablees without datatype
#age=21
#isAdult=True

##print(("\n"+name)*100) #printing names 100 times in each single line
#print(f"(name)and (age)")

#using lists
#names=["sonali","ashika","akrithi"] #creating a list
#print(names[1])

#using tuples
#names_tuples=("sonali","ashika","akrithi") #cannot modify the value
#print(names)

#names_tuples[2]="anish" #cannont modify

#names_set=["sonali","ashika","akrithi","sonali"] #removes duplicate values
#print(names_set)

#names_dictionary={"sonali":23,"ashika":19,"akrithi":2} #creating dictionary key:value pairs
#print(names_dictionary)

#names_dictionary={"sonali":23,"ashika":19,"akrithi":2} 
#print(names_dictionary.keys()) #printing only key

#names_dictionary={"sonali":23,"ashika":19,"akrithi":2} 
#print(names_dictionary.values()) #printing only values

#names=["sonali","ashika","akrithi","sonali"]
#print(names.count("sonali"))

#if statement
'''name="santhoji" 
inputvalue=input("Enter name:")

if name==inputvalue:
    print(True)
elif name=="sam":
    print("TrueFalse")
else:
    print(False)    '''

#for statement
'''name="santhoji"
names_new=[]
names=["deekha","kavya","deekshitha"]

for i in range(1,11):
    print(i)'''

#input from user and is display is user enter even odd or invalid

'''inputvalue:input("Enter number:")
if (inputvalue%2==0):
    print("Even")
elif(inputvalue%2!=0):
    print("odd")
else:
    print("invalid")    '''

'''num=input("enter int")
if(num.isnumeric()):
    if(int(num)%2==0):
        print("even") 
    else:
        print("odd")
else:
    print("invalid")         '''

num=input("enter int") 
if(num.isnumeric() and int(num)%2==0):
    print("even")

'''def oddeven():
    n=int(input("enter no:"))
    if(n%2==0)
oddeven()



num=int(input("enter no:"))
if num%2!=0:
    result("odd")
print(result)    '''

