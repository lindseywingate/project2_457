use LWP::Simple;

$webpage = 'http://www.accuweather.com/en/us/grand-forks-nd/58203/weather-forecast/329834';

$source = get $webpage;

#print "$source\n";
if ($source =~ /Current Weather<\/a><\/h3>(.*)/s)
{
   $theRest = $1;
   if ($theRest =~ /(-?\d{1,3})&deg/)
   {
      print "Current temp is $1\n";
      if ($theRest =~ /Tomorrow(.*)/s)
      {
         $theRest = $1;
         if ($theRest =~ /(-?\d{1,3})&deg/)
         {
            print "Tomorrow's high should be $1\n";
         }
      }
   }
}
else
{
   print "Unable to find current temperature\n";
}
