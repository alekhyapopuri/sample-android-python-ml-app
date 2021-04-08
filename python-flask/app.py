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
                mdvpfo=request.json['MDVP:Fo(Hz)']
                mdvpfhi=request.json['MDVP:Fhi(Hz)']
                mdvpflo=request.json['MDVP:Flo(Hz)']
                mdvpjitterper=request.json['MDVP:Jitter(%)']
                mdvpjitterabs=request.json['MDVP:Jitter(Abs)']
                mdvprap=request.json['MDVP:RAP']
                mdvpppq=request.json['MDVP:PPQ']
                jitterddp=request.json['Jitter:DDP']
                mdvpshimmer=request.json['MDVP:Shimmer']
                mdvpshimmerdb=request.json['MDVP:Shimmer(dB)']
                shimmerapq3=request.json['Shimmer:APQ3']
                shimmerapq5=request.json['Shimmer:APQ5']
                mdvpapq=request.json['MDVP:APQ']
                shimmerdda=request.json['Shimmer:DDA']
                nhr=request.json['NHR']
                hnr=request.json['HNR']
                rpde=request.json['RPDE']
                dfa=request.json['DFA']
                spread1=request.json['spread1']
                spread2=request.json['spread2']
                d2=request.json['D2']
                ppe=request.json['PPE']
     
    features_value=[[mdvpfo,mdvpfhi,mdvpflo,mdvpjitterper,mdvpjitterabs,mdvprap,mdvpppq,jitterddp,mdvpshimmer,mdvpshimmerdb,shimmerapq3,shimmerapq5,
                     mdvpapq,shimmerdda,nhr,hnr,rpde,dfa,spread1,spread2,d2,ppe]]    
            
    features_name = ['MDVP:Fo(Hz)', 'MDVP:Fhi(Hz)', 'MDVP:Flo(Hz)', 'MDVP:Jitter(%)',
       'MDVP:Jitter(Abs)', 'MDVP:RAP', 'MDVP:PPQ', 'Jitter:DDP',
       'MDVP:Shimmer', 'MDVP:Shimmer(dB)', 'Shimmer:APQ3', 'Shimmer:APQ5',
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
