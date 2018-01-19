class ShortestCompletingWord(object):
    def shortestCompletingWord(self, licensePlate, words):
        plate = []
        for i in licensePlate:
            if i.isalpha():
                plate.append(i.lower())
        minStr = ""
        lengthStr = sys.maxint
        for word in words:
            hashMap = {}
            for letter in word:
                if letter in hashMap:
                    hashMap[letter]+=1
                else:
                    hashMap[letter]=1
            matched = 0
            for char in plate:
                if char in hashMap:
                    if hashMap[char]==0:
                        break
                    else:
                        hashMap[char]-=1
                        matched+=1
                else:
                    break
            if len(plate)==matched:
                if(len(word)<lengthStr):
                    minStr = word
                    lengthStr = len(word)
        return minStr
                        
            
            
            
        """
        :type licensePlate: str
        :type words: List[str]
        :rtype: str
        """
        
