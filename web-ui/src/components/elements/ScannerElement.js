import { Html5QrcodeScanner } from 'html5-qrcode'
import React, { useEffect, useState } from 'react'

export default function ScannerElement() {
    const[scanResult,setScanResult] = useState(null);

    useEffect(()=>{
        const scanner = new Html5QrcodeScanner('reader', {
            qrbox: {
                width: 400,
                height: 400,
            },
            fps: 5,
        });

        scanner.render(success, error);

        function success(result) {
            scanner.clear();
            setScanResult(result);
        }

        function error(err) {
            console.log(err)
        }
    },[]);
   

  return (
    <>
          {scanResult ? <div>Success: <a href={'http://' + scanResult}>{scanResult}</a></div> : <div id='reader'></div>}
    </>
    
  )
}
