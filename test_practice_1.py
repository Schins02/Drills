def Class Double_Linked_List(object)	:


	def Class Node()	:
		node_class_var = "The Node Class Var"


		def __init__(self, data, prev, next)	:
			self.data = data
			self.prev = prev
			self.next = next


	def __init__(self)	:
		self.size = 0
		self.head = None
		self.tail = None


	def add_first(data) :
		if(self.size == 0):
			temp_node = Node(data, None, None)
		else:
			temp_node = Node(data, None, self.head)

		self.size += 1	



	def add(data)	:
		#if size == 0 :
		if self.size == 0 :
			add_first(data)
		else:
			






