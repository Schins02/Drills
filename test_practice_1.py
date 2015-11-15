class Double_Linked_List(object)	:


	class Node(object)	:
		node_class_var = 99


		def __init__(self, data, prev, next)	:
			self.data = data
			self.prev = prev
			self.next = next


	def __init__(self)	:
		self.size = 0
		self.head = None
		self.tail = None


	def add_first(self, data) :
		if(self.size == 0):
			temp_node = Double_Linked_List.Node(data, None, None)
			self.head = temp_node
			self.tail = temp_node
		else:
			temp_node = Node(data, None, self.head)
			temp_node = self.head

		self.size += 1	


	def add(self, data)	:
		if self.size == 0 :
			self.add_first(data)
		else:
			temp_node = Double_Linked_List.Node(data, None, None)
			self.tail.next = temp_node
			self.tail = temp_node

		self.size += 1


	def get(self, pos) : 
		if self.size == 0 or pos > self.size:	
			return None

		this_pos = 0
		temp_node = self.head

		while this_pos < pos :
			temp_node = temp_node.next			

		return temp_node.data

#begin
my_list = Double_Linked_List()

my_list.add(10)
my_list.add(20)

print(my_list.get(0))

