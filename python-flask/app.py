# -*- coding: utf-8 -*-
"""
Created on Sat Mar 14 11:32:24 2020

@author: ALEKHYA
"""

import numpy as np
import pandas as pd
from flask import Flask, request, jsonify, render_template
import pickle

app = Flask(__name__)
model = pickle.load(open('model.pkl', 'rb'))

@app.route('/')
def home():
    return render_template('index.html')

@app.route('/predict',methods=['POST'])
def predict():
                params=rquest.get_json()
                mdvpfo=params['MDVP:Fo(Hz)']
                mdvpfhi=params['MDVP:Fhi(Hz)']
                mdvpflo=params['MDVP:Flo(Hz)']
                mdvpjitterper=params['MDVP:Jitter(%)']
                mdvpjitterabs=params['MDVP:Jitter(Abs)']
                mdvprap=params['MDVP:RAP']
                mdvpppq=params['MDVP:PPQ']
                jitterddp=params['Jitter:DDP']
                mdvpshimmer=params['MDVP:Shimmer']
                mdvpshimmerdb=params['MDVP:Shimmer(dB)']
                shimmerapq3=params['Shimmer:APQ3']
                shimmerapq5=params['Shimmer:APQ5']
                mdvpapq=params['MDVP:APQ']
                shimmerdda=params['Shimmer:DDA']
                nhr=params['NHR']
                hnr=params['HNR']
                rpde=params['RPDE']
                dfa=params['DFA']
                spread1=params['spread1']
                spread2=params['spread2']
                d2=params['D2']
                ppe=params['PPE']
     
                features_value=[[mdvpfo,mdvpfhi,mdvpflo,mdvpjitterper,mdvpjitterabs,mdvprap,mdvpppq,jitterddp,mdvpshimmer,mdvpshimmerdb,shimmerapq3,shimmerapq5,
                     mdvpapq,shimmerdda,nhr,hnr,rpde,dfa,spread1,spread2,d2,ppe]]    
            
                features_name = ['MDVP:Fo(Hz)', 'MDVP:Fhi(Hz)', 'MDVP:Flo(Hz)', 'MDVP:Jitter(%)','MDVP:Jitter(Abs)', 'MDVP:RAP', 'MDVP:PPQ', 'Jitter:DDP','MDVP:Shimmer', 'MDVP:Shimmer(dB)', 'Shimmer:APQ3', 'Shimmer:APQ5',
                'MDVP:APQ', 'Shimmer:DDA', 'NHR', 'HNR', 'RPDE', 'DFA',
                'spread1', 'spread2', 'D2', 'PPE']
   
                df = pd.DataFrame(features_value, columns=features_name)
    
                res = model.predict(df)
                output=res[0]
    
                print(output)
       
                if output == 0:
                   res_val = "no parkinsons disease "
                else:
                   res_val = "** parkinsons disease **"
       

                return res_val





if __name__ == "__main__":
    app.run(debug=True)
