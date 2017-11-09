#Written By: Michele Bell
#PE 11
#Program to calculate average rainfall

#Validate entry for years
def validate_years():
    while True:
        try:
            value = int(input("Enter number of years: "))
        except ValueError:
            print("Entry is not a valid number.")
        else:
            if value <= 0:
                print("Entry is less than 1.")
            else:
                break
    return value

#Validate entry for rainfall
def validate_rain():
    while True:
        try:
            rain = float(input("Enter rainfall for month:"))
        except ValueError:
            print("Entry is not a valid number.")
        else:
            if rain < 0:
                print("Entry can not be a negative number.")
            else:
                break
    return rain       
         
   
def main():
    #Declare variables
    monthRain = 0.0
    months = 0
    avgRain = 0.0
    totalRain = 0.0

    #Get user input for number of years
    years = validate_years()

    #Get average rainfall per month
    for year in range(years):
        print("Year ", year + 1, ":")
        for month in range(12):
            monthRain = validate_rain()
            #Add to number of months
            months = months + 1
            #Add to total rainfall
            totalRain = totalRain + monthRain

    #Calculate average rainfall
    avgRain = totalRain / months

    #Display results
    print("Number of months: ", months)
    print("Total of all rainfall: ", totalRain, "inches.")
    print("The average monthly rainfall is: ", avgRain, "inches.")
                                      
main()                    
        
                    
