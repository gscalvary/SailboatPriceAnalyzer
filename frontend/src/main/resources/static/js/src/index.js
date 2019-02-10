var app = new Vue ({
    el: '#app',
    data () {
        return {
            rawData: null
        }
    },
    filters: {
      toLengthDecimal (value) {
        if (typeof value !== "number") {
            return value;
        }
        return value.toFixed(1)
      },
      toUSDCurrency (value) {
        if (typeof value !== "number") {
            return value;
        }
        var formatter = new Intl.NumberFormat('en-US', {
            style: 'currency',
            currency: 'USD',
            minimumFractionDigits: 2
        });
        return formatter.format(value)
      }
    },
    mounted () {
        axios
            .get('/v1/data/all.json')
            .then(response => (this.rawData = response.data))
   }
})
