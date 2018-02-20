'''

 
 QUITO 
==============
'''
import couchdb
import sys
from tweepy import Stream
from tweepy import OAuthHandler
from tweepy.streaming import StreamListener
import json
 
 
##########API CREDENTIALS ############   Poner sus credenciales del API de dev de Twitter
ckey = "UeL7TiHbkxjHe7TNWrIHDN3Ca"
csecret = "7dwSQ1VJeQNI8hCdqZfrS6wlspRvsS570PLVmhZAdTkcOcwtI4"
atoken = "945668740015894528-YPFt1RaorWAbqFwHIbwJ1xUCyjbz2Xg"
asecret = "xeRZMJC74gIEo6a8F65Kcf3JyDqpPV6gkX49ThQJ4CeBJ"
 
class listener(StreamListener):
 
    def on_data(self, data):
        dictTweet = json.loads(data)
        try:
            dictTweet["_id"] = str(dictTweet['id'])
            doc = db.save(dictTweet)
            print "SAVED" + str(doc) +"=>" + str(data)
        except:
            print "Already exists"
            pass
        return True
 
    def on_error(self, status):
        print status
 
auth = OAuthHandler(ckey, csecret)
auth.set_access_token(atoken, asecret)
twitterStream = Stream(auth, listener())
 
 
if len(sys.argv)!=3:
    sys.stderr.write("Error: needs more arguments: <URL><DB name>\n")
    sys.exit()
 
URL = sys.argv[1]
db_name = sys.argv[2]
 
 
'''========couchdb'=========='''
server = couchdb.Server('http://'+URL+':5984/')  #('http://245.106.43.184:5984/') poner la url de su base de datos
try:
    print db_name
    db = server[db_name]
 
except:
    sys.stderr.write("Error: DB not found. Closing...\n")
    sys.exit()
 
 
'''===============LOCATIONS=============='''
 
twitterStream.filter(locations=[-78.593445,-0.370099,-78.386078,-0.081711])  #QUITO
