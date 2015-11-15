
"""method to find sum of all primes below @param limit"""
def sum_primes_below_limit(limit):
	sum = 0
	primes = [False] * (limit + 1)
	index = 2
	multiplier = 2

	while index <= limit:
		multiplier = 2
		while multiplier * index <= limit:
			primes[multiplier * index] = True
			multiplier += 1
		index += 1

	index = 2
	while index <= limit:
		
		if primes[index] == False:
			sum += index
		index += 1

	return sum


print sum_primes_below_limit(2000000)
