#examples taken and re-written/modified from dive into python 3

import re

#goal is to replace Road with Rd. for set of addresses
str = '3301 North BROAD ROAD'
str = str.replace('ROAD', 'Rd.')
assert(str == '3301 North BRd. Rd.')

#regex to the rescue
str = '3301 NORTH BROAD ROAD'
str = re.sub('ROAD$', 'RD.', str )	#$ meta-char matches if given expression is @ end of the string
assert(str == '3301 NORTH BROAD RD.')


#What if the address left our the ROAD designation?
str = '3301 NORTH BROAD'
str = re.sub('ROAD$', 'RD.', str )	
assert(str == '3301 NORTH BRD.') #not good

#lets specify to the regex that we want to match ROAD when 
#it is at the end of String AND when it is its own word   \b indicates word break
str = '3301 NORTH BROAD'
str = re.sub(r'\bROAD$', 'RD.', str)
assert(str == '3301 NORTH BROAD') # no harm done


#BUT there are things called apartments/condos/etc. that screw things up
str = '3301 NORTH BROAD ROAD apt. 124'
#we can adjust and make the regex match ROAD as a word that doesn't have to end the string
str = re.sub(r'\bROAD\b', 'RD.', str)
assert(str =='3301 NORTH BROAD RD. apt. 124')

#PHONE NUMBERS













