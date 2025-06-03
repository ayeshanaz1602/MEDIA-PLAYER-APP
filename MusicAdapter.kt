inner class MusicViewHolder(view: View) : RecyclerView.ViewHolder(view) {
    val title: TextView = view.findViewById(R.id.songTitle)
    init {
        view.setOnClickListener {
            onItemClick(items[adapterPosition])
        }
    }
}

override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MusicViewHolder {
    val view = LayoutInflater.from(parent.context)
        .inflate(R.layout.item_audio, parent, false)
    return MusicViewHolder(view)
}

override fun onBindViewHolder(holder: MusicViewHolder, position: Int) {
    holder.title.text = items[position].title
}

override fun getItemCount(): Int = items.size
