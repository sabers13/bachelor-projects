class disjointSet:
    def __init__(self, elements):
        self.elements = elements
        self.root = {}
        for element in elements:
            self.make_set(element)

    def make_set(self, set1):
        self.root[set1] = set1

    def find(self, set1):
        if self.root[set1] == set1:
            return set1
        else:
            self.root[set1] = self.find(self.root[set1])
            return self.root[set1]

    def union(self, set1, set2):
        set1Root = self.find(set1)
        set2Root = self.find(set2)
        self.root[set1Root] = set2Root
