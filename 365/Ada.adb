--Lindsey Wingate, lindseymwingate@gmail.com
--DESCRIPTION: 
with Ada.Text_IO;use Ada.Text_IO;
with Ada.Integer_Text_IO; use Ada.Integer_Text_IO;
with Ada.Float_Text_IO; use Ada.Float_Text_IO;

procedure make_array is

    type MY_ARRAY is array(1..100) of INTEGER;
    Total : INTEGER;
    Length : INTEGER;
    Index : INTEGER;
    Biggest : INTEGER;
    MEAN : FLOAT := 000.00;
    Count : INTEGER;
    Length_Count : INTEGER;
    One_Char : INTEGER;
    First : MY_ARRAY;
    Sort_Temp : INTEGER;
    
begin
    Count := 1;
    Put("Please enter integers: ");
    loop
        Get(One_Char);
        Put(One_Char);
        First(Count) := One_Char;
        Count := Count + 1;
        New_Line;
        exit when One_Char<=0;
    end loop;
    New_Line(2);
    
--This loop counts how many and totals the array for the mean
    Length := 1;
    Total := 0;
    Length_Count := 0;
    loop
        Total := First(Length) + Total;
        Length := Length + 1;
        New_Line;
        Length_Count := Length_Count + 1;
        exit when First(Length)<=0;
    end loop;
    New_Line;
 
--This loop finds the biggest number in the array  
    Index := 0;
    Biggest := 0;
    loop
        Index := Index + 1;
        exit when First(Index)<=0;
        if Biggest<First(Index) then
            Biggest := First(Index);
        end if;
    end loop;
    New_Line;
    
--This loop sorts the array
For_Loop_1:
    for A in integer range 1..Length_Count loop
    For_Loop_2:
        for I in integer range 1..Length_Count loop
            if First(I)>First(I+1) then
                Sort_Temp := First(I);
                First(I) := First(I+1);
                First(I+1) := Sort_Temp;
            end if;
    end loop For_Loop_2;
end loop For_Loop_1;

--Prints out final results of sort
    put("Numbers in Array");
    new_line(1);
For_Loop:
    for c in integer range 1..Length_Count+1 loop
        if(First(c)/=0) then
            put(First(c));
            new_line(1);
        end if;
end loop For_Loop;
    
--Final print statements
    Put("Biggest Number in Array: ");
    new_line(1);
    Put(Biggest);
    new_line(1);
    Put("Average of values: ");
    MEAN := FLOAT(Total/Length_Count);
    Put(MEAN);

end make_array;
