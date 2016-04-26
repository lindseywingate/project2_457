ndsey Wingate, lindseymwingate@gmail.com
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
    
    Put(Biggest);
    Put(Length_Count);
    Put(Total);
    MEAN := FLOAT(Total/Length_Count);
    Put(MEAN);

end make_array;
